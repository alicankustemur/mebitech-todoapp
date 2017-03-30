# Todo App

 This is a simple **Spring Boot** and **React** project.
 
 The goal of the project ; save **employees**, **departments** and **meetings** information to using basic database operations.
 
 ![MebitechTodoApp Screenshoot](http://alicankustemur.github.io/images/others/mebitech-todoapp.PNG)
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

Run **MySQL** and go to [http://localhost:8082/mebitech-todoapp/] 

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
mvn -Dtest=CreateTestDataServiceTest  test
mvn -Dtest=EmployeeServiceTest  test
mvn -Dtest=DepartmentServiceTest  test
mvn -Dtest=MeetingServiceTest  test
```
