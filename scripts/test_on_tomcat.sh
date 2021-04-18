#!/bin/bash

docker stop tomcat
mvn clean install -f ./api/RestAPI/pom.xml
docker-compose -f docker-compose-tmp-v-ubuntu.yml up -d tomcat
docker exec tomcat catalina.sh start
