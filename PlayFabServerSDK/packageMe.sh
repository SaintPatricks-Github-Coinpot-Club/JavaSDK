#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.96.190828.jar ../../builds/server-sdk-0.96.190828.jar
