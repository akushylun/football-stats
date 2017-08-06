football-stats App

football-stats is a REST APIs example built with H2 database and Spring Boot.
Spring Boot provides the RESTful API. H2 stores data.

Installation

1. Clone the repository: git clone https://github.com/akushylun/football-stats.git
2. Install the application: mvn package
3. Start the application java -jar football-stats-0.0.1-SNAPSHOT.jar 
4. View in browser:

4.1 Enter User Name 'admin' and Password 'pass' on http://localhost:8080  
  
4.2 (GET method in request) http://localhost:8080/teams
4.3 (GET method in request)  http://localhost:8080/teams/1
4.4 (POST method in request with json object in the body) http://localhost:8080/teams
4.5 (PUT method in request with json object in the body) http://localhost:8080/teams/1
4.6 (DELETE method in request) http://localhost:8080/teams/1
