#/bin/bash

mvn package

pushd ../
mkdir -p ./builds
popd

cd target
cp  client-sdk-0.132.210521.jar ../../builds/client-sdk-0.132.210521.jar
