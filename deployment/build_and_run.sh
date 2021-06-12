#!/bin/bash

cd /home/cms-wiki-fi9e
# Stop the application if running
docker-compose down
#docker volume rm cms-wiki-fi9e_tomcat

# Build the Java app
mvn clean install -f ./api/RestAPI/pom.xml

# Build the Angular app
cd angular
npm install
npm update
ng build --configuration production
cd ..

# Start the app in detached mode
docker-compose up -d
