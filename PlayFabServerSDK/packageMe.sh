#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.97.190903.jar ../../builds/server-sdk-0.97.190903.jar
