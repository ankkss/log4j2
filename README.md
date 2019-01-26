# log4j2
simple java spring rest api integrated with log4j2

# Project deployment: 
- Web application deployment: 
Its an maven project build it with command: mvn clean install
copy war file in tomcat webapp or any web application deployment.
- Jetty deployment:
Jetty plugin already added in pom.xml
For deployment use command: jetty:run

Rest api URL to check server logs: http://localhost:8080/log4j2/rest/samplelog4j?level=info
In this level in url is used to define log level(info, warn, error)

For log4j2 configuration reference check: log4j2\src\main\resources\log4j2.xml 
