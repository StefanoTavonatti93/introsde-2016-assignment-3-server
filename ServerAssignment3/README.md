#introsde-2016-assignment-3-server
Stefano Tavonatti

##Introduction
This is the server for the third assignment of the *Introduction to Service Design and Engineering* course

##Package structure

- **introsde.assignment.soap**: this package contains the interface which defines the methods that the server exposes. This package also contains the implementation of the interface.
- **introsde.document.dao**: this package contains the *LifeCoachDao.java* which handle the connection with the database
- **introsde.document.endpoint**: this package contains the *PeoplePublisher.java* class which creates and publishes an endpoint for the *People* service.
- **tavonatti.stefano.model**: this package contains the classes used by the persistence provider to map the data on the database to Java objects.

##Compile and run
In order to compile and run the server type the following commands:

```shell
ant install
ant start  
```
The server starts on "*http://127.0.1.1:6902/ws/people?wsdl*"

##Heroku
- This server is deployed on heroku and it is available at the following address: [https://assignment-3-tavonatti.herokuapp.com/ws/people?wsdl](https://assignment-3-tavonatti.herokuapp.com/ws/people?wsdl "")
- I worked in pair with Simone Scalco, this is the link for his server: [https://scalco-introsde-assignment-3.herokuapp.com/ws/people?wsdl](https://scalco-introsde-assignment-3.herokuapp.com/ws/people?wsdl "")

##Client
The client repository is located at [https://github.com/StefanoTavonatti93/introsde-2016-assignment-3-client](https://github.com/StefanoTavonatti93/introsde-2016-assignment-3-client "")