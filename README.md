# Todo App

 This is a simple **Spring Boot** and **React** project.
 
 The goal of the project ; save employees, departments and meeting information to using basic database operations.
 

## Requirements

### Build
 - Maven
 - JDK 8
 
### Run

 These ones must be installed on your os for run.
 - Maven 
 - MySQL 
 - JRE 8
 
## Installation

### Build
Run command-line in the project path and call it on command-line.
```sh
java -jar mebitech-todoapp.jar
```

### Run

Run **MySQL** and  and go to [http://localhost:8082/mebitech-todoapp/] 

Call these commands for running test classes.

```sh
mvn test
```
or one
```sh
mvn -Dtest=IndexControllerTest  test
mvn -Dtest=EmployeeControllerTest  test
mvn -Dtest=DepartmentControllerTest  test
mvn -Dtest=MeetingControllerTest  test
mvn -Dtest=EmployeeServiceTest  test
mvn -Dtest=DepartmentServiceTest  test
mvn -Dtest=MeetingServiceTest  test
```
