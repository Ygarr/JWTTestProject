- Used many other jwt-spring projects including "Cerberus"

- mvn spring-boot:run -Dmaven.test.skip=true (-Dorg.zaxxer.hikari=DEBUG)
- or
- ./gradlew  build -x test

- commands
- curl -i -H "Content-Type: application/json" -X POST -d '{"username":"test","password":"wrong"}' http://localhost:8080/TestProject/auth
- curl -i -H "Content-Type: application/json" -X POST -d '{"username":"test","password":"correct"}' http://localhost:8080/TestProject/auth
#<!-- case: curl -i -X POST -d username=user -d password=userPass http://localhost:8080/TestProject/auth-->
- curl -i -H "Content-Type: application/json" -H "X-TOKEN: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTQ4OTA4NDA5MTE2OSwiZXhwIjoxNDg5Njg4ODkxfQ.FSXmEOgk07ZCVZ22EmENj6WS0aEba8j81oR_wcfTcjCjPYb0hxQut9XqbB-toWjWWAQGeuiVD00AT9s7XuFl6Q" -X GET http://localhost:8080/TestProject/user/1



- Made with:
- IntelliJ IDEA 2016.3.5
Build #IU-163.13906.18, built on March 6, 2017
JRE: 1.8.0_112-release-408-b6 amd64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o

- DB Package: postgresql
Version: 9.6+179

-  OS: Debian 9.0 stretch
 Kernel: x86_64 Linux 4.10.1-towo.1-siduction-amd64
