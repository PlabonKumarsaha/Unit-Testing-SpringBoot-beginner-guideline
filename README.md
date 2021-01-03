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

** must know annotations: **

- @DisplayName – defines custom display name (in the testing console) for a test class or a test method
- @BeforeEach – denotes that the annotated method will be executed before each and every test method (previously @Before in Junit4)
- @AfterEach – denotes that the annotated method will be executed after each and every test method (previously @After in junit4)
- @BeforeAll – denotes that the annotated method will be executed <b> before ALL</b> test methods in the current class (previously @BeforeClass in junit4)
- @AfterAll – denotes that the annotated method will be executed <b> after ALL</b> test methods in the current class (previously @AfterClass in junit4)
- @Disable – it is used to disable a test class /method (previously @Ignore in junit4)



