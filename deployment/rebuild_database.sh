#!/bin/bash

docker volume rm cms-wiki-fi9e_mysql_data

docker-compose down
docker-compose up --build -d
