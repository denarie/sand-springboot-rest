# Sand SpringBoot Rest

This is the sand collection backend of the sand collection applications.
It was migrated from a Microsoft Access Database to a MySQL database. Hence the domain object use table name 
and column name annotations to map the existing names.

The sand collection domain consists of
 * Sand: the sand samples that were collected with their geo coordinates
 * Person: the person that collected the sand. This is an m:n relationship
 * Country, Continent: Contain more detailed information about where the sand was collected
 * Link: information linked to a sand object, this can be internet links (urls) or image links
 * SandProperty: some settings for the application

## Howto build and run

Sometimes starting via IntelliJ does not work because of Lombok
See [https://github.com/projectlombok/lombok/issues/849#issuecomment-370668962](https://github.com/projectlombok/lombok/issues/849#issuecomment-370668962)
then use
```
mvn spring-boot:run
```

Or add the following to the maven compiler plugin:
```
    <annotationProcessorPaths>
        <path>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
        </path>
        <path>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.36</version>
        </path>
    </annotationProcessorPaths>
```

Build:
```
mvn clean verify
```

Run with profile dev:
```
java -jar -Dspring.profiles.active=dev target/sand-0.0.1-SNAPSHOT.jar 
```

Run in production:

On the production server create a subdirectory in the directory where the jar file is:

config/application-prod.properties

```
java -jar -Dspring.profiles.active=prod sand-0.0.1.jar 
```

On some servers you need to define java home and add it to the path so that the application runs:

```
export JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64
export PATH=${PATH}:${JAVA_HOME}/bin
```
