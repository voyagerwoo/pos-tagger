#!/usr/bin/env bash

aws lambda invoke \
--invocation-type RequestResponse \
--function-name pos-tagger \
--region ap-northeast-1 \
--payload "\"$1\"" \
outputfile.txt

cat outputfile.txt
