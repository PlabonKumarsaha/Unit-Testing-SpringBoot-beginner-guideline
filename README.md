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


**Must know annotations:** 
 

- assertEquals - value checking
- assertTrue - condition checking
- assertThrows- For exception checking
- assertNotNull
- assertNotSame
- assertArrayEquals

Checkout the *[Examples](https://junit.org/junit5/docs/current/user-guide/)*

### Example of Console application junit test of a calculator's functions : 

[calculator class](https://github.com/PlabonKumarsaha/Unit-Testing-SpringBoot-beginner-guideline/blob/main/ConsoleAppTest/src/newTest/Calculator.java) <br>
[Test functions](https://github.com/PlabonKumarsaha/Unit-Testing-SpringBoot-beginner-guideline/blob/main/ConsoleAppTest/src/newTest/CalculatorTest.java)

## Spring boot API testing 

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
- [x] Check deafult message
- [x] Service Testing
- [x] Controller testing
- [x] Repository testing


### Repository Testing

1. Add @RunWith(SpringRunner.class) and @DataJpaTest annotation on the class Name.
2. Autowired the Repository class that `you want to test`
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
        Users findUser = usersRepository.findByLogin(users.getLogin());
        assertThat(findUser).isNotNull(); //look if there is any null alue
        assertThat(findUser.getName()).isEqualTo(users.getName()); //compare the values of isnance and data query
    
```
8. Choose Run as test and see the output

### **Hello world controller test**

```
@Controller
public class HelloController { // the controller class

	@RequestMapping("/")
	public @ResponseBody String greeting() {
		return "Hello, World";
	}

}
```
```
@SpringBootTest //step1
public class SmokeTest {

	@Autowired
	private HelloController controller; // step 2 : autowire the controller

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull(); //check if it is not null
	}
}
```
This will check if the value matches or not
```
@WebMvcTest //step 1
public class WebLayerTest {

	@Autowired
	private MockMvc mockMvc; //step2

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World"))); //step3
	}
}

```

### **Service testing**
in the Sample_crud project [Service](https://github.com/PlabonKumarsaha/Unit-Testing-SpringBoot-beginner-guideline/blob/main/spring_Sample_crud/src/test/java/com/javamaster/spring_crud/service/DefaultUsersServiceTest.java) was tested like the following

***The steps***

1. Add the following snippets:
```
private UsersRepository usersRepository;
private UsersService usersService;
private UsersConverter usersConverter; // This helps to connect the class and DTO
```

2. Now Mock the UserRepository and create an isnatnce of DTO class
```
usersRepository = mock(UsersRepository.class);
 usersConverter = new UsersConverter();
```

3. create the instance of service by passing the userRepository and userConverter as a parameter
```
usersService = new DefaultUsersService(usersRepository, usersConverter); 
```

4. Now `Let's check` the create service
```
 @Test
    void saveUser() throws ValidationException {
        when(usersRepository.save(any())).thenReturn(userDto); // mocks the save and checks the return value
        UsersDto createdUser = usersService.saveUser(userDto); 
        assertThat(createdUser).isNotNull(); //checks if the created user is null
        assertThat(createdUser.getName()).isEqualTo(userDto.getName()); //comapre the given  value and gotten value from repo is same or mot
    }
```

5. Excaeption checking

```
   @Test
    void saveUserThrowsValidationExceptionWhenLoginIsNull() { //checks for exception
        UsersDto usersDto = aUserDTO();
        usersDto.setLogin("");
        assertThrows(ValidationException.class,
                () -> usersService.saveUser(usersDto),
                "Login is empty");
    }

```

6. Test the service method

```
 void findByLogin() {
        when(usersRepository.findByLogin(eq("test_login"))).thenReturn(newUser); // when mocks the repository and 
        UsersDto foundUser = usersService.findByLogin("test_login"); // tries to find the user and stores it in a DTO instance
        assertThat(foundUser).isNotNull(); // checks if the value is found
        assertThat(foundUser.getLogin()).isEqualTo("test_login"); // check if the value is correct or not
    }
```

### **Controller testing**
in the Sample_crud project `check the` [Controller](https://github.com/PlabonKumarsaha/Unit-Testing-SpringBoot-beginner-guideline/blob/main/spring_Sample_crud/src/main/java/com/javamaster/spring_crud/controller/UsersController.java) that was tested like the following manner 

**Steps**
1.Add `@WebMvcTest(UsersController.class)` before the test class

2. Mock the MockMvc
```
@Autowired
MockMvc mockMvc;
 ```
3. Autowire any class instance if it was used . ex: In this project ObjectMapper was used to to the DTO and class mapping.
 
4. Create a Mock bean of service insatnce
 ```
 @MockBean
 UsersService usersService;
 ```
 5. Now let's look at how does the create URL is hitten
 ```
     @Test
    void saveUsers() throws Exception {
        when(usersService.saveUser(any())).thenReturn(userDto); // mocking the service and schecks if it returns a DTO
        mockMvc.perform(post("/users/save") //mocks the Controller path
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(userDto)));
 }
 ```
### **Repository testing**
In the Sample_crud project `check the` [Repository](https://github.com/PlabonKumarsaha/Unit-Testing-SpringBoot-beginner-guideline/blob/main/spring_Sample_crud/src/main/java/com/javamaster/spring_crud/repository/UsersRepository.java) that was tested like the following manner 






