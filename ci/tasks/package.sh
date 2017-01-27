#!/bin/sh

set -e +x

cd movie-fun-cnc-source
./mvnw clean package
mv target/movie-fun-0.0.1-SNAPSHOT.jar ../package-output/movie-fun.jar
