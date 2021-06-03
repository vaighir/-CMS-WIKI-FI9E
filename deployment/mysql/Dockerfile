FROM mysql:8.0.23

ENV MYSQL_ROOT_PASSWORD='root' \
    MYSQL_USER='user' \
    MYSQL_PASSWORD='password' \
    MYSQL_HOSTNAME='mysql' \
    MYSQL_DATABASE='test_db'

COPY ../../docker/mysql_data /docker-entrypoint-initdb.d

RUN apt-get update && apt-get -y install locales && \
    sed -i '/en_US.UTF-8/s/^# //g' /etc/locale.gen && \
    locale-gen

ENV LANG: en_US.UTF-8 \
    LANGUAGE: en_US:en \
    LC_ALL: en_US.UTF-8

EXPOSE 3306 33060

ENTRYPOINT ["docker-entrypoint.sh"]

CMD ["mysqld"]
