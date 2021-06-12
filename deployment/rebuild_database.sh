#!/bin/bash

cd /home/cms-wiki-fi9e
docker-compose down
docker volume rm cms-wiki-fi9e_mysql_data

docker-compose up --build -d
