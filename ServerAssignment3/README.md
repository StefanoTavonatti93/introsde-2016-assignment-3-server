#introsde-2016-assignment-3-server
Stefano Tavonatti

###Package structure

- **introsde.assignment.soap**: this package contains the interface which defines the methods that the server exposes. This package also contains the implementation of the interface.
- **introsde.document.dao**: this package contains the *LifeCoachDao.java* which handle the connection with the database
- **introsde.document.endpoint**: this package contains the *PeoplePublisher.java* class which creates and publishes an endpoint for the *People* service.
- **tavonatti.stefano.model**: this package contains the classes used by the persistence provider to map the data on the database to Java objects.

##Compile and run