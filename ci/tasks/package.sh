#!/bin/sh

set -e +x

cd movie-fun-cnc-source
./gradlew clean build > /dev/null
mv applications/movie-fun-app/build/libs/movie-fun-app-1.1.0-SNAPSHOT.war ../package-output/movie-fun.war
