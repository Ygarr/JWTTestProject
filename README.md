# spring-boot-jwt-example

A simple JWT token based authentication using Spring Boot.

./gradlew  build -x test
 java -jar build/libs/simple-jwt-0.0.1-SNAPSHOT.jar

psql -h localhost -U titan titandb


curl -XPOST -v -H 'Content-Type: application/json' http://localhost:8080/api/public/auth -d '{"userName":"user1", "passWord":"123"}'

curl -XGET -v -H 'Content-Type: application/json' http://localhost:8080/api/public/hello/customer

curl -XGET -v -H 'Content-Type: application/json' http://localhost:8080/api/secure/hello/customer

curl -POST -v -H 'Content-Type: application/json' http://localhost:8080/TestProject/auth -d '{"userName":"user1", "passWord":"123"}'
eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI0MWJmN2E1ZS04OWFkLTQ5Y2QtYWQ4MC1iMWFmOWEzZDIwYTEiLCJzdWIiOiJ1c2VyMSIsInJvbGUiOiIxMjMiLCJpYXQiOjE0ODgyNzc5NDUsImV4cCI6MTQ4ODM2NDM0NX0.DDrCmzd_y_yzhJraoHSZWvgXAucYNLcWPqVf6l0upfAt57eTfJu7eoh8HY6Ga4I-QtoMC67QO83RRvEvtE_-9Q


curl -POST -v -H 'Content-Type: application/json' http://localhost:8080/TestProject/user/1 -d '{"x-auth-token":"eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI0MWJmN2E1ZS04OWFkLTQ5Y2QtYWQ4MC1iMWFmOWEzZDIwYTEiLCJzdWIiOiJ1c2VyMSIsInJvbGUiOiIxMjMiLCJpYXQiOjE0ODgyNzc5NDUsImV4cCI6MTQ4ODM2NDM0NX0.DDrCmzd_y_yzhJraoHSZWvgXAucYNLcWPqVf6l0upfAt57eTfJu7eoh8HY6Ga4I-QtoMC67QO83RRvEvtE_-9Q"}'

curl -GET -v -H "X-TOKEN:eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI5YTBiNjZiYi0zNWVlLTRiNDctYjI0My04YWVlMDJlZjQwMzgiLCJzdWIiOiJ1c2VyMSIsInJvbGUiOiIxMjMiLCJpYXQiOjE0ODgyNzg4MDUsImV4cCI6MTQ4ODM2NTIwNX0.2DNWvwGh5FnPdc-JZj79wPeJmzPZwuc0H4jDOQCIz4KdjQn4jH4WrOjUM3Sz3uP2ge6cK4jZmLQCLd-VJJBu-A" http://localhost:8080/TestProject/user/1

curl -GET -i -H "X-TOKEN:eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI5YTBiNjZiYi0zNWVlLTRiNDctYjI0My04YWVlMDJlZjQwMzgiLCJzdWIiOiJ1c2VyMSIsInJvbGUiOiIxMjMiLCJpYXQiOjE0ODgyNzg4MDUsImV4cCI6MTQ4ODM2NTIwNX0.2DNWvwGh5FnPdc-JZj79wPeJmzPZwuc0H4jDOQCIz4KdjQn4jH4WrOjUM3Sz3uP2ge6cK4jZmLQCLd-VJJBu-A" http://localhost:8080/TestProject/user/1
 
