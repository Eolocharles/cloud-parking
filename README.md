# Cloud Parking
A simple parking lot management system.
## Getting Started
### Prerequisites
java 17
### Installing
```
git clone
cd cloud-parking
mvn clean install

```
### Running
```
java -jar target/cloud-parking-1.0-SNAPSHOT.jar
``` 
## Running the tests
```
mvn test
```
## Run database
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine

## Start and Stop

### Stop Database
docker stop parking-db

### Start Database
docker start parking-db
## Built With
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework
* [postgresql](https://www.postgresql.org/) - Database
## Authors
* **Éolo Charles** - *Initial work* - [Éolocharles](




