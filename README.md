Application is developed using Spring Boot, Spring JPA, Maven, Java 8, STS,Swagger, Actuators,Rest Services, JUnit

# Actuator

http://localhost:8086/actuator/  - Lists all actuator rest end points
http://localhost:8086/actuator/mappings" - Lists all actuator mappings

# Rest Service Documentation using Swagger

http://localhost:8085/swagger-ui.html Swagger UI
http://localhost:8085/v2/api-docs

GET    	/api/stations 				List all Stations
POST   	/api/stations 				Create a station
GET    	/api/stations/{id} 			Search a station with an ID
PUT	   	/api/stations/{id}			Update a station with an ID
DELETE	/api/stations/{id}			Delete a station with an ID
GET		/api/stations/hdDisabled	List all stations which are not HD enabled
GET		/api/stations/hdEnabled		List all HD enabled stations
GET		/api/stations/name={name}	Search a station with a name


Station{
	description:	
	Class representing a Station.
	
	callSign*	string
	allowEmptyValue: false
	The callsign of the station
	
	hdEnabled	boolean
	id	integer($int64)
	allowEmptyValue: false
	The database generated station Id
	
	name*	string
	allowEmptyValue: false
	The name of the station
	
	version	integer($int32)
	allowEmptyValue: false
	The auto-generated version of the station

}

# Maven
	pom.xml file
# Model 
	Station.java
	
	Station{
		description:	
		Class representing a Station.
		
		callSign*	string
		allowEmptyValue: false
		The callsign of the station
		
		hdEnabled	boolean
		id	integer($int64)
		allowEmptyValue: false
		The database generated station Id
		
		name*	string
		allowEmptyValue: false
		The name of the station
		
		version	integer($int32)
		allowEmptyValue: false
		The auto-generated version of the station

}
# Data Layer (JPA Repository)
	StationRepository.java
# Service Layer -	Interface
	StationService.java
# Service Layer -	Implementation
	StationServiceImpl.java
# Controller Layer
	StationController.java
# Exception Handling
	ResourceNotFoundException.java
# Spring Application 
	SpringBootWebApplication.java
# Spring Application Bootstrap
	SpringJpaBootstrap.java
	
