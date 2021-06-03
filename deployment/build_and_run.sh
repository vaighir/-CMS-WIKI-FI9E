#!/bin/bash

docker volume rm cms-wiki-fi9e_tomcat

mvn clean install -f ./api/RestAPI/pom.xml

cd angular
npm install
npm update
ng build --configuration production
cd ..

docker-compose down
docker-compose up -d
