#! /bin/bash
set -ex

if [ -z $MOVIE-FUN-CNC-SOURCE ]; then
  echo "MOVIE-FUN-CNC-SOURCE not set"
  exit 1
fi

pushd movie-fun-cnc-source
  echo "Running smoke tests for Attendee Service deployed at $ATTENDEE_SERVICE_URL"
  apt-get update && apt-get install -y curl
  smoke-tests/bin/test $MOVIE-FUN-CNC-SOURCE
popd

exit 0
