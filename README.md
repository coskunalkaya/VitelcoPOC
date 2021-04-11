# Turkcell POC Project
This is a sample Java / Maven / Spring Boot.

### How to Run
This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the java -jar command.

- Clone this repository
- Make sure you are using JDK 1.8, Maven and MongoDB 
- You can build the project and run the tests by running mvn clean package
- Once successfully built, you can run the service by one of these two methods:
<pre>
        java -jar -Dspring.profiles.active=test target/turkcellpoc-0.0.1-SNAPSHOT.jar
or
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
</pre>

- Check the stdout to make sure no exceptions are thrown

### About the Service
getMenuList, getProductList and updateProductInfo are REST service. It uses an in-memory MongoDB to store the data.

Here is what this little application demonstrates:

- Full integration with the latest Spring Framework: inversion of control, dependency injection, etc.
- Packaging as a single war with embedded container (tomcat 8): No need to install a container separately on the host just run using the java -jar command
- Writing a RESTful service using annotation: supports JSON request / response; simply use desired Accept header in your request
- Automatic CRUD functionality against the data source using MongoRepository pattern
- Log information is kept in MongoDB
- Demonstrates MockMVC test framework with associated libraries
- All APIs are "self-documented" by Swagger2 using annotations

### Get information about services
Here are some endpoints you can call:
<pre>
http://localhost:8080/api/getMenuList
http://localhost:8080/api/getProductList
http://localhost:8080/api/updateProductInfo
</pre>

### getMenuList
<pre>
curl --location --request GET 'http://localhost:8080/api/getMenuList'

Response: HTTP 200
Content: menu list 
</pre>

### getProductList
<pre>
curl --location --request GET 'http://localhost:8080/api/getProductList'

Response: HTTP 200
Content: product list 
</pre>

### updateProductInfo
<pre>
curl --location --request PUT 'http://localhost:8080/api/updateProductInfo' \
--header 'Content-Type: application/json' \
--data-raw '[
    "gsmNo1",
    "gsmNo2"
]'

Response: HTTP 200
Content: update result
</pre>

### To view Swagger 2 API docs
Run the server and browse to localhost:8080/swagger-ui.html
