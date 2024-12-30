package de.denarie.sand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
Zum Testen muss die Anwendung außerhalb von IntelliJ gestartet werden, da sonst die Properties fehlen, die per Lombok gefüllt werdem

https://github.com/projectlombok/lombok/issues/849#issuecomment-370668962

Also Terminal öffnen und

mvn spring-boot:run
 */

@SpringBootApplication
public class SandApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandApplication.class, args);
	}

}
