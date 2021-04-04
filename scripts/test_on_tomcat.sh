docker stop tomcat
mvn clean install -f ./api/RestAPI/pom.xml
docker-compose up -d tomcat
