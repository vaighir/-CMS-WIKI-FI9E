#!/bin/bash

docker-compose down
docker volume rm cms-wiki-fi9e_mysql_data

docker-compose up --build -d
