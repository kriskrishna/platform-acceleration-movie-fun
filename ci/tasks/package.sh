#!/bin/sh

set -e +x

cd movie-fun-cnc-source
./gradlew clean build -xtest > /dev/null
pwd
ls applications/movie-fun-app/build/libs
ls ../
mv applications/movie-fun-app/build/libs/movie-fun-app-1.1.0-SNAPSHOT.war ../package-output/movie-fun.war
