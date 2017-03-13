- Used many other jwt-spring projects including "Cerberus"

- mvn spring-boot:run -Dmaven.test.skip=true 
- curl -i -H "Content-Type: application/json" -X POST -d '{"username":"test","password":"wrong"}' http://localhost:8080/TestProject/auth
- curl -i -H "Content-Type: application/json" -X POST -d '{"username":"test","password":"correct"}' http://localhost:8080/TestProject/auth
#<!-- case: curl -i -X POST -d username=user -d password=userPass http://localhost:8080/TestProject/auth-->

- curl -i -H "Content-Type: application/json" -H "X-TOKEN: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTQ4OTA4NDA5MTE2OSwiZXhwIjoxNDg5Njg4ODkxfQ.FSXmEOgk07ZCVZ22EmENj6WS0aEba8j81oR_wcfTcjCjPYb0hxQut9XqbB-toWjWWAQGeuiVD00AT9s7XuFl6Q" -X GET http://localhost:8080/TestProject/user/1
- ./gradlew  build -x test