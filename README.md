## Unit-Testing- guidelines
### This repo has : 
- [x] Test on maven
- [ ] Test on gradle


### The required dependencies in [Pom](https://github.com/PlabonKumarsaha/Unit-Testing-SpringBoot-beginner-guideline/blob/main/ToDoRestApiTest/pom.xml) file:

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

**Must know annotations:**

- @DisplayName – defines custom display name (in the testing console) for a test class or a test method
- @BeforeEach – denotes that the annotated method will be executed before each and every test method (previously @Before in Junit4)
- @AfterEach – denotes that the annotated method will be executed after each and every test method (previously @After in junit4)
- @BeforeAll – denotes that the annotated method will be executed <b> before ALL</b> test methods in the current class (previously @BeforeClass in junit4)
- @AfterAll – denotes that the annotated method will be executed <b> after ALL</b> test methods in the current class (previously @AfterClass in junit4)
- @Disable – it is used to disable a test class /method (previously @Ignore in junit4)
- @EnabledOnOs - look to run on only specific OS .The other OS will be disabled
- @EnabledOnJre - looks to run on particular JRE versions of java
- @RepeatedTest - Repeates a test multiple time.


**Must know annotations:** *[Examples](https://junit.org/junit5/docs/current/user-guide/)*
 

- assertEquals - value checking
- assertTrue - condition checking
- assertThrows- For exception checking
- assertNotNull
- assertNotSame
- assertArrayEquals

### Example of Console application junit test of a calculator's functions : 

[calculator class](https://github.com/PlabonKumarsaha/Unit-Testing-SpringBoot-beginner-guideline/blob/main/ConsoleAppTest/src/newTest/Calculator.java) <br>
[Test functions](https://github.com/PlabonKumarsaha/Unit-Testing-SpringBoot-beginner-guideline/blob/main/ConsoleAppTest/src/newTest/CalculatorTest.java)


### Check the default controller message for controller testing

**In the controller class :**
```
@RequestMapping("/")
   @ResponseBody
   public String returnSomething() {
   	return "Hello, World"; 
   	}
	
```

**Now let’s test the controller:**
1.	Create a class as a test and annotate it with “@SpringBootTest”
2.	Autowire any dependent class if there is a dependency of it in the controller class(ex : in my case there is a dependency of service class in the controller class).
3.	Create an instance of the controller class and pass the dependent object type.
4.	If there is no such dependency ignore 2,3 and directly autowire the Controller class
5.	Now check if the controller is not null first 
Ex : 
``` 
assertThat(toDoController).isNotNull(); 

```
6.	Then create an instace of MockMvc by autowiring
7.	Now use this :
```
           @Test
		public void shouldReturnDefaultMessage() throws Exception {
			this.mockMvc.perform(get("/api/")).andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("Hello, World")));
		}
		
```

### **Test CRUD Operation in spring**

***Additional added dependency:*** This is a in memory dependency which helps to test the database <b>without changing the database</b>.It is used for running <b>integration test</b> cases for which you want to use <b>temporary data</b> instead of using actual data in your DB.

```
<dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>test</scope>
</dependency>
```	
**Add them in the properties file**

```
spring.datasource.url =jdbc:h2:mem:testdb
spring.datasource.username= root
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver

```

**Going to do :**
- [x] Repository Testing
- [x] CRUD operation with spring JPA
- [ ] Create Testing
- [ ] Update Testing
- [ ] Update Testing
- [ ] Delete testing
- [ ] Controller testing

### Repository Testing

1. Add @RunWith(SpringRunner.class) and @DataJpaTest on the class Name.
2. Autowired the repository
3. Create a class instance for the enitity that the JpaRepository is extending(here User)
4. Save the insance in h2 demo Database(save the user)
5. Now test the user created JPA function : **findByLogin** which returns a User class
6. Check if the return is null or not
7. Now test the newly crated value with the User, getname.

```
        Users users = new Users();
        users.setName("test_name");
        users.setLogin("test_login");
        usersRepository.save(users); // save in demo database
        //check the findByLogin method
        Users foundUser = usersRepository.findByLogin(users.getLogin());
        assertThat(foundUser).isNotNull(); //look if there is any null alue
        assertThat(foundUser.getName()).isEqualTo(users.getName()); //compare the values of isnance and data query
    
```
8. Choose Run as test and see the output

### **Service testing**




