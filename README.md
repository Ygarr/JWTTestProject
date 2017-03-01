# spring-boot-jwt-example

A simple JWT token based authentication using Spring Boot.

Related blog article:
http://andreinc.net/2016/09/10/simple-authentication-with-spring-boot-and-jwt-tokens/


./gradlew  build -x test && java -jar build/libs/simple-jwt-0.0.1-SNAPSHOT.jar



psql -h localhost -U titan titandb


○ → curl -XPOST -v -H 'Content-Type: application/json' http://localhost:8080/api/public/auth -d '{"userName":"user1", "passWord":"123"}'
Note: Unnecessary use of -X or --request, POST is already inferred.
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /api/public/auth HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.52.1
> Accept: */*
> Content-Type: application/json
> Content-Length: 38
> 
* upload completely sent off: 38 out of 38 bytes
< HTTP/1.1 200 OK
< Date: Tue, 28 Feb 2017 10:11:04 GMT
< X-Application-Context: application
< Content-Type: text/plain;charset=utf-8
< Content-Length: 251
< 
* Curl_http_done: called premature == 0
* Connection #0 to host localhost left intact
eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJhOWYwNzA3ZC1mOGUzLTRiZmItOWQ4Yy01OTdkZWQzMmFmN2UiLCJzdWIiOiJ1c2VyMSIsInJvbGUiOiIxMjMiLCJpYXQiOjE0ODgyNzY2NjQsImV4cCI6MTQ4ODM2MzA2NH0.6TlpjKKngOcednHRA-PcFQ6dz3gm6ju_7DhBEeZ4TKQ8Y3ZfY4-JyqKo-Y-YSft268jIDF6B9yEKtFhyn5963g




curl -XGET -v -H 'Content-Type: application/json' http://localhost:8080/api/public/hello/tvarina

Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /api/public/hello/tvarina HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.52.1
> Accept: */*
> Content-Type: application/json
> 
< HTTP/1.1 200 OK
< Date: Tue, 28 Feb 2017 10:26:23 GMT
< X-Application-Context: application
< Content-Type: text/plain;charset=utf-8
< Content-Length: 28
< 
* Curl_http_done: called premature == 0
* Connection #0 to host localhost left intact
Hello JWT, tvarina! (Public)




curl -XGET -v -H 'Content-Type: application/json' http://localhost:8080/api/secure/hello/tvarina

curl -GET -v -H 'Content-Type: application/json' http://localhost:8080/api/public/hello/tvarina



curl -POST -v -H 'Content-Type: application/json' http://localhost:8080/api/public/auth -d '{"userName":"user1", "passWord":"123"}'
eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI0MWJmN2E1ZS04OWFkLTQ5Y2QtYWQ4MC1iMWFmOWEzZDIwYTEiLCJzdWIiOiJ1c2VyMSIsInJvbGUiOiIxMjMiLCJpYXQiOjE0ODgyNzc5NDUsImV4cCI6MTQ4ODM2NDM0NX0.DDrCmzd_y_yzhJraoHSZWvgXAucYNLcWPqVf6l0upfAt57eTfJu7eoh8HY6Ga4I-QtoMC67QO83RRvEvtE_-9Q


curl -POST -v -H 'Content-Type: application/json' http://localhost:8080/api/secure/hello/user1 -d '{"x-auth-token":"eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI0MWJmN2E1ZS04OWFkLTQ5Y2QtYWQ4MC1iMWFmOWEzZDIwYTEiLCJzdWIiOiJ1c2VyMSIsInJvbGUiOiIxMjMiLCJpYXQiOjE0ODgyNzc5NDUsImV4cCI6MTQ4ODM2NDM0NX0.DDrCmzd_y_yzhJraoHSZWvgXAucYNLcWPqVf6l0upfAt57eTfJu7eoh8HY6Ga4I-QtoMC67QO83RRvEvtE_-9Q"}'

curl -GET -v -H "x-auth-token:eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI5YTBiNjZiYi0zNWVlLTRiNDctYjI0My04YWVlMDJlZjQwMzgiLCJzdWIiOiJ1c2VyMSIsInJvbGUiOiIxMjMiLCJpYXQiOjE0ODgyNzg4MDUsImV4cCI6MTQ4ODM2NTIwNX0.2DNWvwGh5FnPdc-JZj79wPeJmzPZwuc0H4jDOQCIz4KdjQn4jH4WrOjUM3Sz3uP2ge6cK4jZmLQCLd-VJJBu-A" http://localhost:8080/api/secure/hello/anyuser

→ curl -GET -i -H "x-auth-token:eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI5YTBiNjZiYi0zNWVlLTRiNDctYjI0My04YWVlMDJlZjQwMzgiLCJzdWIiOiJ1c2VyMSIsInJvbGUiOiIxMjMiLCJpYXQiOjE0ODgyNzg4MDUsImV4cCI6MTQ4ODM2NTIwNX0.2DNWvwGh5FnPdc-JZj79wPeJmzPZwuc0H4jDOQCIz4KdjQn4jH4WrOjUM3Sz3uP2ge6cK4jZmLQCLd-VJJBu-A" http://localhost:8080/api/secure/hello/tvarina
HTTP/1.1 200 OK
Date: Tue, 28 Feb 2017 10:54:30 GMT
X-Application-Context: application
Content-Type: text/plain;charset=utf-8
Content-Length: 28

Hello JWT, tvarina! (Secure)
