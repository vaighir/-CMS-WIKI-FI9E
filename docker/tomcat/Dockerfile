FROM tomcat:9.0.45-jdk8-openjdk-slim-buster

WORKDIR ${CATALINA_HOME}

RUN mv /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps

EXPOSE 8080

CMD ["catalina.sh", "run"]
