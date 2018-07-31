#!/usr/bin/env bash

./mvnw clean compile package
aws lambda update-function-code --function-name pos-tagger --zip-file fileb://./target/pos-tagger-0.0.1.jar
