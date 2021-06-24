# TAXI Coding Challenge

This was my interview code submission for a Taxi 24 company.

## Description

Taxi24 is a new startup based in Kigali. They would like to disrupt the taxi industry in Rwanda by providing a white-label solution to the
existing taxi companies and hotels. Practically, they will build a set of APIs that other companies can use to manage their fleet of drivers
and allocate drivers to passengers. The challenge is to build the below defined backend APIs.

## Requirements

This project requires that PostgreSQL 10-12 be installed.


## Installation

After cloning the project, you'll need to have the maven installed to build the project. Run the following:

```
mvn install
```

Build using the following command if you want to skips tests while building

```
mvn install -DskipTests
```

Once that is done, you'll need to configure the project to connect to your Postgres database:

```
db = postgres
username = postgres
passowrd = root
```

You'll also want to execute the contents of `data.sql` in the resource folder before you start the server.

## Running

To start the server, you will need to run this command `mvn spring-boot:run` via the commandline

## HTTP Endpoints

The service provides three HTTP endpoints for answering the questions asked in the "Dispatch Backend" document.

### DRIVERS
#### Get a list of all drivers

	Method: GET
    URL: localhost:8080/driver/all

#### Get a list of all available drivers

	Method: GET
    URL: localhost:8080/driver/all-active

#### Get a list of all available drivers within 3km for a specific location

	Method: GET
    URL: localhost:8080/driver/all-active-by-distance
    Headers:
        distance: 20.0
        location: 45,56      

[comment]: <> (location is a cardinal point of the format x,y, and distance is in km)

#### Get a specific driver by ID


	Method: GET
    URL: localhost:8080/driver/id
    Headers:
        driverId: f5d6a17d-8eaf-48ca-bd1e-3bcdf0eeda7c
[comment]: <> (  the driver is a UUID, you can get samples in `data.sql`)

### TRIPS
#### Create a new ‘Trip’ request by assigning a driver to a rider

	Method: POST
    URL: localhost:8080/request/create-trip
    Headers:
        riderId: afd1f854-8662-491b-abbf-6384f1fb0164
        driverId: 3093311f-00de-46c9-a4b2-426f4cf16604
        destinationLocation: 45,56  

#### Complete a trip

	Method: PUT
    URL: localhost:8080/request/complete-trip
    Headers:
        tripId: bf5e6ba4-93e1-4107-86fa-53c1212701d9

#### Get a list of all active Trips

	Method: GET
    URL: localhost:8080/trip/all-active-trips


### RIDER
#### Get a list of all riders

    Method: GET
    URL: localhost:8080/rider/all

#### Get a specific rider by ID

	Method: GET
    URL: localhost:8080/rider/id
    Headers:
        riderId: f5d6a17d-8eaf-48ca-bd1e-3bcdf0eeda7c
[comment]: <> (  the riderId is a UUID, you can get samples in `data.sql`)


#### For a specific driver, get a list of the 3 closest drivers

    Method: GET
    URL: localhost:8080/request/get-closed-drivers
    Headers:
        riderId: d6c7f25c-e205-4ec6-89ea-a9ccb1ffa2da

## Known Issues

This is a simple implementation of how it can work. 
In an enterprise application there are more things that could be added such:
    
    - more validation of the data
    - making transactions transactional
    - Better handling of error message
    - Adding More logging
    - Better exception handling
    - Adding toString, equals methods, states and version on models for optimistic locking, deactivation and so forth
    - More abstraction for common fields