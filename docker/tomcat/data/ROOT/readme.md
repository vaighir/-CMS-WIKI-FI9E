# CMS Prototype V1
In this project we like to demonstrate how an Angular + REST-API + Tomcat Server architecture based CMS could look like.

Have a look at: [http://localhost/admin](http://localhost/admin) to get an overview of all pages the project consists of.

## Project folders

### angular
The Angular folder contains all angular app files.

### tomcat_local
The tomcat_local folder contains the source files of an tomcat server for reference purposes. We use some config files from the local tomcat server that get injected into the tomcat docker container to set it up.

## Docker
For this prototype we will be using docker-compose in order to define and orchestrate our services we need.

### Docker Services in this project
1. Tomcat Server:
- Used to host Angular webapp
- Runs our REST-API with which the Angular App communicates

2. MySQL Database:
- Simple MySQL Database Service that contains our database tables
- has `init.sql` script that set´s up our database schema

### Docker Compose cheatsheet
All the commands below have to be execute in a terminal (cmd) in the root folder of the docker-compose.yml file. Otherwise you need to specify on which docker-compose file you like to execute the commands on.

- Start docker services (e.g. tomcat):
`docker-compose up -d`

- Stop docker serices:
`docker-compose down`

- Build docker image:
`docker-compose build`


# Tomcat - Quickstart
1. open command line
2. Start and build docker imag first time:
`docker-compose up --build -d`
3. go to browser address: http://locahost
4. put your website into the "app/" folder
5. hit refresh in browser, enjoy :)

# Angular - Quickstart
When working with Angular and tomcat there are just two things to consider.
If you develop the Angular app, use the angular provided server. If you like to deploy the Angular app when you are done developiong, build the angular project.

### Angular Browser Link
The Angular app is available under: http://localhost/websites/cms/

## Angular app developement:
When developing the Angular app the dev workflow looks like this:

Start angular watchers and start the dev server for developement:
- cd into "angular" folder in project
- use command `ng serve --open` to start dev server and auto open the webpage

## Angular app deployment:
In order to deploy the angular app to tomcat and test it on the server, you will need to build the angular app first. The angular build command, will build the project and copy it automatically to the "websites/cms" folder in this project. The websites folder is injected into the tomcat docker container, so you don´t need to do anything else other than browse to the angular app Link ()

Build the angular app:
- cd into "angular" folder in project
- use command `ng build --prod` to build the angular app.

The built Angular app is copied into the "website/cms" folder in the project.
