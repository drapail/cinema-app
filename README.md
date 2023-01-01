# [Cinema App](http://dibrov-cinema-app.herokuapp.com/login)
This application implements functionality for a cinema with several halls.
It is possible to register visitors who will be able to purchase tickets for a certain time in the selected hall
The project is built using Java and popular frameworks such as Spring and Hibernate.
Includes authentication/authorization, REST, and a global wait handler.

---
## Features :

### For Admin role

- Registration and authorization (POST: /register, GET: /login)

    - Viewing:
    - cinema halls (GET: /cinema-halls)
    - movies (GET: /movies)
    - available movie sessions (GET: /movie-sessions/available)
- Add new:
    - cinema halls (POST: /cinema-halls)
    - movies (POST: /movies)
    - movie sessions (POST: /movie-sessions). "showTime" should be passed as a list: [YYYY,m,d,HH,mm,ss]
- Update and delete movie session (PUT: /movie-sessions/{id}, DELETE: /movie-sessions/{id})
- Get some user by email (GET: /users/by-email)
- Logout (GET: /logout)
### For User role
- Registration and authorization (POST: /register, GET: /login)
- Viewing:
    - cinema halls (GET: /cinema-halls)
    - movies (GET: /movies)
    - available movie sessions (GET: /movie-sessions/available)
- Get orders and shopping carts (GET: /orders, GET: /shopping-carts/by-user)
- Complete orders (POST: /orders/complete)
- Add tickets to shopping cart for some movie session (PUT: /shopping-carts/movie-sessions)
- Logout (GET: /logout)
### For All
- Registration and authorization (POST: /register, GET: /login)

# Entity relationships can be seen in the diagram
![Entity relationships can be seen in the diagram](Spring_Cinema_Uml.png)

---

## Technologies used:
- Java 11
- Hibernate
- Spring Framework
- REST
- MySQL
- Apache Tomcat 9.0.54 (to run app locally)

---

## To start the project you need:

1. Download and install Java 11 SDK.
2. Download and install Tomcat (version 9.0.63).
3. Download and install MySQL.
4. Create schema (cinema)
5. Clone project to your IDE.
6. Add your username, password and DB url in db.properties file.
7. Use Postman to send requests.

## For testing, use ready-made profiles:
1. Admin
- Login: admin@i.ua
- Password: admin123
2. User
- Login: regular@i.ua
- Password: regular321

# Heroku

This project is also deployed to Heroku. AWS RDS MySQL instance is used as a DB. You can click it via this link:
[Heroku Link](http://dibrov-cinema-app.herokuapp.com/login)
