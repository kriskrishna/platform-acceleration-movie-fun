#! /bin/bash
set -ex

if [ -z $MOVIE-FUN-CNC-SOURCE ]; then
  echo "MOVIE-FUN-CNC-SOURCE not set"
  exit 1
fi

pushd movie-fun-cnc-source
  echo "Running smoke tests for Attendee Service deployed at $ATTENDEE_SERVICE_URL"
  apt-get update && apt-get install -y curl
  curl movie-fun-cnc-supersingular-sportfulness.cfapps-02.haas-66.pez.pivotal.io
popd

exit 0
