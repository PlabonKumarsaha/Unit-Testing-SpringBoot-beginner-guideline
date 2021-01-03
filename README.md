## Unit-Testing- guidelines
### This repo has : 
- [x] Test on maven
- [ ] Test on gradle


### The required dependencies in Pom file:

```
 <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-api</artifactId>
			<scope>test</scope>
		</dependency>
```
### If you are using an older release version of Junit testing use this dependency:
The Junit4 library gets added by default if you are working on an older rerelease version of spring . Junit5 is the latest version which you want to work on.
```
	<!-- exclude junit 4 -->
			<exclusions>
				<exclusion>
					<groupId>junit</groupId>
					<artifactId>junit</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

		<!-- junit 5 -->
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-api</artifactId>
			<scope>test</scope>
		</dependency>
```

now while opening a new project `you should be given a separate directory to keep your test codes.So When you run your business code the test files will be ignored.`

