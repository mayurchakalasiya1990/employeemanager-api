# employee-manager

It is Spring-boot Application which is created using Intellij IDE. 

This Project is developed to 

Features:
1) Implement Application Security using Spring Security.
2) Create APIs and expose to client side Application(Angular 8).
3) Implement JWT (JSON Web Token) to secure communication and decode, verify and generate Token.
4) Spring and Servlet Filters are used to intercept client requests, valid tokens and configure Cross Site Scripting.
5) JPA repository is used to fetch employee and user data from MySQL DB. 

There are two resource classes available to serve client requests.

1) EmployeeResource.java

Endpoints: To perform CRUD operations on employee data

http://localhost:8080/employee/all

http://localhost:8080/employee/find/{id}

http://localhost:8080/employee/add

http://localhost:8080/employee/update

http://localhost:8080/employee/delete/{id}


2) JWTResource.java

Endpoints: To validate user and generate JWT token for client request

http://localhost:8080/employee/employeeAuth/token
