Über IntelliJ klappt Lombok nicht zur Laufzeit, es fehlen Attribute.
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
