#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  server-sdk-0.131.210511.jar ../../builds/server-sdk-0.131.210511.jar
