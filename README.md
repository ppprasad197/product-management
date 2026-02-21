###Tech Stack

Java 17+

Spring Boot 3.5.x

Spring Data JPA (Hibernate)

MySQL

Spring Security (JWT + Refresh Token)

### Dependencies
Add spring-boot-starter-data-jpa, spring-boot-starter-web, spring-boot-devtools,
mysql-connector-j, spring-boot-starter-security, jjwt-api, jjwt-impl, jjwt-jackson,

After adding dependencies use
"mvn clean install" use this command

### Database Configuration
### Option 1
spring.datasource.url=jdbc:mysql://localhost:3306/productdb
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
CREATE DATABASE productdb;

### Option 2(automatic database creation)
spring.datasource.url=jdbc:mysql://localhost:3306/productdb?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=yourusername
spring.datasource.password=yourpassword

### JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

