#!/bin/bash

echo "### remove all images###"
docker kill $(docker ps -q)

echo "### remove all docker images###"
docker rmi $(docker images -q)

echo "###remove all and force docker images###"
docker rmi -f $(docker images -q)

echo "### run docker selenium standalone chrome image"

# running  the image and executing the test
docker run -d -p 4444:4444 --shm-size=2g selenium/standalone-chrome:3.141.59-zinc
mvn -U clean test

