# employee-manager

It is Spring-boot Application which is created using Intellij IDE. 


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

UI of Client Side Application :

Login Page :
![image](https://user-images.githubusercontent.com/32035137/117537886-52883680-b021-11eb-9ad6-8845fad6bdbd.png)

Dashboard:

![image](https://user-images.githubusercontent.com/32035137/117537945-93804b00-b021-11eb-841b-7a0d69081990.png)

Add Employee:

![image](https://user-images.githubusercontent.com/32035137/117537970-b0b51980-b021-11eb-9f43-2be5275fa4b2.png)

Edit Employee Detaits: 

![image](https://user-images.githubusercontent.com/32035137/117538012-ce827e80-b021-11eb-92aa-6d7aaa0eff9f.png)

Delete Employee Details :

![image](https://user-images.githubusercontent.com/32035137/117538040-eb1eb680-b021-11eb-8bf4-e526172defc7.png)



