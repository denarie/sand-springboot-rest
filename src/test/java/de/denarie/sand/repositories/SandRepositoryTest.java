package de.denarie.sand.repositories;

import de.denarie.sand.domain.Continent;
import de.denarie.sand.domain.Country;
import de.denarie.sand.domain.Person;
import de.denarie.sand.domain.Sand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SandRepositoryTest {

    @Autowired
    SandRepository sandRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ContinentRepository continentRepository;

    @Autowired
    CountryRepository countryRepository;

    private Continent continent1;
    private Continent continent2;


    @BeforeEach
    void setUp() {
        Sand sand1 = Sand.builder().name("sand1").longname("sand1 longname").build();
        Sand sand2 = Sand.builder().name("sand2").longname("sand2 longname").build();
        Sand sand3 = Sand.builder().name("sand3").longname("sand3 longname").build();

        Person person1 = Person.builder().name("person1").build();
        Person person2 = Person.builder().name("person2").build();

        Country country1 = Country.builder().nameDe("country1").build();
        Country country2 = Country.builder().nameDe("country2").build();
        Country country3 = Country.builder().nameDe("country3").build();
        Country country4 = Country.builder().nameDe("country4").build();

        continent1 = Continent.builder().name("continent 1").build();
        continent2 = Continent.builder().name("continent 2").build();

        sand1.addPerson(person1);
        sand2.addPerson(person1);
        sand2.addPerson(person2);
        sand3.addPerson(person2);

        sand1.setCountry(country1);
        sand2.setCountry(country2);
        sand3.setCountry(country3);

        country1.setContinents(Set.of(continent1, continent2));
        country2.setContinents(Set.of(continent1));
        country3.setContinents(Set.of(continent1));
        country4.setContinents(Set.of(continent2));

        sandRepository.save(sand1);
        sandRepository.save(sand2);
        sandRepository.save(sand3);

        personRepository.save(person1);
        personRepository.save(person2);

        continentRepository.save(continent1);
        continentRepository.save(continent2);

        countryRepository.save(country1);
        countryRepository.save(country2);
        countryRepository.save(country3);
        countryRepository.save(country4);
    }

    @Transactional
    @Test
    void testReadSandList() {
        long count = sandRepository.count();
        assertEquals(3, count);

        Page<Country> allCountriesWithSands = countryRepository.findAllCountriesWithSands(PageRequest.of(10,10));
        assertEquals(3, allCountriesWithSands.getTotalElements());

        Page<Country> countries1 = countryRepository.findByContinentIdWithPagination(continent1.getId(), PageRequest.of(10, 10));
        assertEquals(3, countries1.getTotalElements());

        Page<Country> countries2 = countryRepository.findByContinentIdWithPagination(continent2.getId(), PageRequest.of(10, 10));
        assertEquals(2, countries2.getTotalElements());

        Page<Person> persons = personRepository.findByNameLikeIgnoreCase("PERSON1", PageRequest.of(10, 10));
        assertEquals(1, persons.getTotalElements());

        List<Sand> allSandsByContinent1 = sandRepository.findAllSandsByContinent(continent1.getId());
        assertEquals(3, allSandsByContinent1.size());

        List<Sand> allSandsByContinent2 = sandRepository.findAllSandsByContinent(continent2.getId());
        assertEquals(1, allSandsByContinent2.size());
    }
}
