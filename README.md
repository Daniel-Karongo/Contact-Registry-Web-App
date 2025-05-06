# Contact-Registry-Web-App

This project is composed of a springboot backend (I asked if this was okay via email and was given the go-ahead) as well as an angular frontend.
The database is mysql and the ORM is Hibernate (comes with Springboot JPA by default).

For this reason, the database, table and records creation queries are absent because the ORM takes care of this automatically. The database confiugration is, however, in the "application.properties" file in the "Serverside/src/main/resources/" directory. The MySQL and JPA dependency declarations are in the "pom.xml" file in the "Serverside/" directory.




As for the front-end, it is incomplete. I downloaded a free angular template from github "https://github.com/coreui/coreui-free-angular-admin-template", but barely had enough time to modify the same. You can however run "npm install", then "ng serve" to see the template.