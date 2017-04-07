Task assignment: setup ,assumptions and modules
---

1. Project setup

The project has three modules: a front end module, back end module and 
integration test module for the back end module.

2. Assumption/choices

The list of concerts is created as a test double (in ConcertService class).
So the concerts are not stored within a database for the moment.

Time handling is kept very basic, I have chosen the system default timezone, 
which is Europe/Brussels on my machine. The datetime is handle in  the 
"ISO8601 format" in JSON. At the clientside, nothing special is implemented.

3. Back end

In the back end I am using plain Java EE7 and Java 8 technology, the test server
is a wildfly 10.1.0.Final but any certified Java EE 7 server should work. There 
are no extra dependencies shipped, so the WAR size is kept at its minimum.

For JSON parsing I have opted to go with the built in Java EEJSON technology. 
For this simple use case this is sufficient. If advanced mappings were needed, 
I might opt to add a additional dependency. 
No bean validation is added to the model as it was not required. 

The packages are created with the BCE pattern in mind 
(Boundary,Control,Entity). Any package structure would work, but I like the 
clarity of the external API(Boundary) within this BCE architecture.

The build system of this project is Maven 3.

To build the project you should be in the directory where the pom.xml resides 
and you should execute the following maven command:  mvn clean package .

The default port of the server is 8080. I have not externalized this in a 
configuration file as it would be done  in a real world example.

The rest endpoint URL is http://localhost:8080/demo/resources/concerts

A CORS filter is added to the project so the front and back end do not need to
be deployed on the same server. The CORS filter is a bit too liberate for the 
moment, but this is just for demo purposes.

4. Front end

I have chosen to use the latest version of Angular , namely version 4.
Within the front end I opted to add one extra dependency in particular, namely
PrimeNG. PrimeNG is a component library, which has its origin as a JSF component 
library  and is quickly gaining supporters in the angular community. They also 
are working on a component library for React. PrimeNG comes with a lot of 
GUI components all in the same theme. So styling can be done for all components 
at once. Every component has a list of built-in features. For instance , the 
datatable component has built in sorting capability. Most features can also be 
tweaked to your own preferences.

State management in the front end has be kept as simple as possible 
(so no redux for instance).

The  SPA exists only of a one module. It has not been divided into feature module, 
core module and shared module as the size of the app is very limited.

The HTTP rest call is handled within a service component.

The build system is @Angular/cli. This system lets you quickly generate a angular
skeleton app. In fact it is a wrapper around the webpack built system.
There are no tests written in front end.

You should be in the root dir of the front end project and execute the 
following angular cli command: ng serve.

This starts a local server on port 4200 with hot reloading capacity.