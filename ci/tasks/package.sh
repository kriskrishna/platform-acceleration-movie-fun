#!/bin/sh

set -e +x

mkdir -p package-output/applications/movie-fun-app/build/libs/
ls package-output

cd movie-fun-cnc-source
./gradlew clean build -xtest > /dev/null

cp manifest.yml ../package-output/
mv applications/movie-fun-app/build/libs/movie-fun-app-1.1.0-SNAPSHOT.war ../package-output/applications/movie-fun-app/build/libs/
mv applications/album-service/build/libs/album-service-1.1.0-SNAPSHOT.jar ../package-output/applications/album-service/build/libs/
mv applications/movie-service/build/libs/movie-service-1.1.0-SNAPSHOT.jar ../package-output/applications/album-service/build/libs/
