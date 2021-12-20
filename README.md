# Clockanize - Organised Time Reporting

***Important! This is a prototype in development...***

Clockanize is a Time Tracking Web Application based on Java Spring Boot.

## Getting Started
The App was created according to the MVC (Model-View-Controller) paradigm. Basis of the View component was made using HTML/CSS/JS.

Deploy the App locally:

* Clone Repository to desired local destination directory
* Create a Database with MySQL (DATABASE, USERNAME and PASSWORD)
* In application.properties enter the DATABASE, USERNAME and PASSWORD:
```Java
spring.datasource.url=jdbc:mysql://localhost:3306/DATABASE?serverTimezone=UTC
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
```
When running the first time use the "CREATE" keyword:
```Java
spring.jpa.hibernate.ddl-auto=create
```
* After that switch back to "UPDATE" and Run "InitialTest" to populate required Data

* Run the project and, in your browser, navigate to URL: localhost:8080

* Default Login:

   [ADMIN]

   **Username:** *admin*

   **Password:** *Admin123*

   [USER]

   **Username:** *test*

   **Password:** *Test1234*

## Technology Stack
* MySQL - Database used

* Java 11 - Java/JDK version used

* Maven - Dependency Management

* Spring Boot - Back-End Framework used with the following dependencies:
  * Spring Boot Security
  * Spring Boot Starter Data JPA
  * Spring Boot Starter Thymeleaf
  * Spring Boot Starter Web (uses Spring MVC)
  * Spring Boot DevTools
  * MySql Connector Java
  * Lombok
  * Spring Boot Starter Test

jQuery - JavaScript Library

IntelliJ - IDE used

## Versioning
* Git for versioning
  * Git Bash - Git CLI
  * GitKraken - Git GUI

## Author
Marcus Mobark (dev0l) - [GitHub](https://www.github.com/dev0l) | [LinkedIn](https://se.linkedin.com/in/marcus-mobark-43358386)
