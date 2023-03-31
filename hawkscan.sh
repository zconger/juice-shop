#!/usr/bin/env bash

AUTH_RESPONSE=$(curl -s 'http://localhost:3001/rest/user/login' -H 'Content-Type: application/json' --data-raw '{"email":"test@test.com","password":"testtest"}')
#AUTH_RESPONSE=$(curl -s 'http://localhost:3001/rest/user/login' -H 'Content-Type: application/json' --data-raw '{"email":"admin@juice-sh.op","password":"admin123"}')

export AUTH_TOKEN=$(jq -r .authentication.token <<< "${AUTH_RESPONSE}")

#hawk scan
