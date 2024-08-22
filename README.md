# Spring Data Demo
Built as a technology demo by Krys Petrie for a tech Spike presentation given on August 15th, 2024.
### Project Overview
This application is a basic Spring MVC web-app that uses a Postgres database, Flyway, Spring Data JDBC, and Spring Data REST. The purpose of this application was to demonstrate some of the out-of-box functionality of Spring Data REST, and help determine if it is a reasonable technology to use in a production application. It models a simple animal inventory for zoos, where you have a zoo, an animal type, and a linkage between the two, which includes counts.

Note: Before starting the application, you must <code>docker compose up -d</code> to start the postgres database.

### Example API Endpoints
This application is fully HATEOAS compliant with a fully discoverable web interface, using JSON. Application root: [http://localhost:8080](http://localhost:8080)

This application exposes a lot of default functionality. Below is a non-exhaustive list of example endpoints to try out.

<table>
<thead>
  <th>Description</th>
  <th>Example Path</th>
  <th>Example JSON Body</th>
</thead>
<tbody>
<tr>
<td>API entrypoint data</td>
<td><code>GET http://localhost:8080</code></td>
<td></td>
</tr>
<tr>
<td>Add an animal</td>
<td><code>POST http://localhost:8080/animal</code></td>
<td><code>{ "name": "Dog", "description": "A domestic canine.", "conservationStatus": "Least Concern"}</code></td>
</tr>
<tr>
<td>Delete an animal</td>
<td><code>DELETE http://localhost:8080/animal/{{entityId}}</code></td>
<td></td>
</tr>
<tr>
<td>Replace an animal</td>
<td><code>PUT http://localhost:8080/animal/{{entityId}}</code></td>
<td><code>{ "name": "Cat", "description": "A furry feline with claws!", "conservationStatus": "Least Concern"}</code></td>
</tr>
<tr>
<td>Search animal by name</td>
<td><code>GET http://localhost:8080/animal/search/findByName?name=Cat</code></td>
</tr>
<tr>
<td>Get zoos, sorted and paged</td>
<td><code>GET http://localhost:8080/zoo?sort=name,desc&page=1&size=2</code></td>
<td></td>
</tr>
<tr>
<td>Search inventory by animal name; custom query</td>
<td><code>GET http://localhost:8080/inventory/search/findByAnimalName?name=Cat</code></td>
<td></td>
</tr>
<tr>
<td>Get a projection inventory counts</td>
<td><code>GET http://localhost:8080/inventory?projection=counts</code></td>
<td></td>
</tr>
</tbody>
</table>

### What does Spring Data REST Promise?
* Auto-magic, low-code REST interface
* Supports all basic CRUD operations
  * plus paging, sorting, filtering, projections
* Automagic [HATEOAS](https://en.wikipedia.org/wiki/HATEOAS) support for API discoverability
* Integrates with JDBC via CrudRepository interface
* Can easily extend with custom queries
* Supports before/after insert event handlers, etc
* Supports version / date conditional rules for insert

### Limitations of Spring Data REST
* NON-REACTIVE applications only! (MVC, JDBC, etc)
  * Would not be great for high-performance web apps
  * e.g. back-pressure, dropped connections, streaming...
* NEAR ZERO data abstraction from repo → API 
  * Good luck trying to conform to complex use cases
  * Changing the API would be a nightmare!
  * Would likely need a gateway service on top of this.
* Configuration can be fiddly

### Where would I use Spring Data REST?
* Internal use, especially where model rarely changes
  * Useful for adding federated, secured access to a database
without needing to spread DB credentials
  * Could help facilitate usage tracking of data, via hooks
* POC applications, early stage where CRUD still works
  * Can gain access to data EXTREMELY quickly over REST
  * Supports a LOT of features out-of-box with minimal config
* TRUSTED applications, since you could massively screw
with the data really easily, without oversight
* If there is no time for OpenAPI documentation, etc