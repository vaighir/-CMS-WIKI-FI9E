FROM bitnami/tomcat:9.0-debian-10

USER root
RUN apt-get update && apt-get install -y iptables socat
# RUN nohup socat TCP-LISTEN:3306,fork TCP:mysql:3306 >> /var/log/socat.log 2>&1 &

EXPOSE 8080 8443


ENTRYPOINT [ "/opt/bitnami/scripts/tomcat/entrypoint.sh" ]
CMD [ "/opt/bitnami/scripts/tomcat/run.sh" ]
