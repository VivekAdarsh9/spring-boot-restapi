# spring-boot-restapi

# Step for creation RestApi project

1.  **Project creation with below dependencies**
```
    i>      Lombok
    ii>     Spring Data JPA
    iii>    PostgreSql Driver
    iv>     Spring Web
```

```
Lombok is a Java library to reduce boilerplate code. It lets developers use annotations and then generates the boilerplate code after the code is compiled. Lombok uses annotation processing to achieve this functionality. The annotation processing was introduced in Java 5 and it is very useful to generate additional source files during the compilation phase.
```

```
Lombok supports a lot of annotations to make the life easy for the developers and they are as follows

@Getter, @Setter
@ToString
@NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor
@EqualsAndHashCode
@Data   (internally uses @Getter @setter @RequiredArgsConstructor @EqualsAndHashCode)
@Builder
@SuperBuilder
@Value
@NonNull
@SneakyThrows
@Synchronized
```

2.  **Create Packaging Structure**

```
    i>      Model
    ii>     Repository
    iii>    Exception
    iv>     Service
    v>      Controller
```

3.  **Modify application.properties as per database configirations details**

```
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=baeldung
spring.datasource.password=baeldung
```
4. **Create JPA Entity model class**

* @Entity specifies that class is an entity
* @Table(name="employees") if we don't provide @Table annotation then JPA will crete table with name as Class name(Employee).
* @Id
* @GeneratedValue(strategy = GenerationType.IDENTITY)

5. **Create Repository interface**

```
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
```
**_NOTE_** : We dont need to provide @Repository annotation as JpaRepository internally configured with the @Repository annotations.

> Spring Data JPA internally provides @Repository annotation so we no need to add @Repository annotation to EmployeeRepository interface

> By Default Spring Data JPA made JpaRepository methods transactional So we no need to add @Transactional annotaion in Service class.


6. **Create ResourceNotFoundException**

* Create your own exception class (eg. ResourceNotFoundException)
* Create Constructer and getter method of the parameter
* Extends your class with RuntimeException
* private static final long serialVersionUID = 1L;
* Add @ResponseStatus(value=HttpStatus=Not_Found) on class


7. **Create Service Layer**

* Service Layer package structure will be like service and service.impl
* service will consists of interface of have method signature
* service.impl will have implemention of service interface
* In serviceimp class we have to inject the EmployeeRepository dependency.

**_NOTE_**:

* Constructor-based dependency injection:- We use whenever we have mandatory parameter.
* Setter-Based dependency injection:- We use whenever we have optional parameter.
```
**Service Package**

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

}
```
*_Note_*:-
* If a class is configured as Spring bean,has only one constructor, the @Autowired annotation can be ommited and Spring will use that constructor and inject all necessary dependencies

```
** Service impl package**

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;


    //Constructor Injection

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

}

```
**_Note_** : Controller layer depends on service layer

8. **Create Controller Layre**


**_Note_**:-
* @RestController is a convenient annotation that compbines @Controller and @ResponseBody, which eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation.

* @RequestBody annotation allows us to retrieve the request's body and automatically convert it in to java Object.
