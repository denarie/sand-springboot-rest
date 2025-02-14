Über IntelliJ klappt Lombok manchmal nicht zur Laufzeit, es fehlen Attribute.
Also so starten:

mvn spring-boot:run

Damit klappt es: Beim maven compiler plugin ergänzen:

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


Bauen
mvn clean package spring-boot:repackage

Das Ergebnis kann dann so gestartet werden:
java -jar target/sand-0.0.1-SNAPSHOT.jar 

Oder so mit Angabe des Profils
java -jar -Dspring.profiles.active=prod sand-0.0.1.jar 

Auf dem Prod-Server muss im Verzeichnis ein Unterverzeichnis sein:
config/application-prod.properties

springboot-rest# export JAVA_HOME=/usr/lib/jvm/java-1.17.0-openjdk-amd64
root@jerrymouse:/opt/spring-boot/sand-springboot-rest# export PATH=${PATH}:${JAVA_HOME}/bin
