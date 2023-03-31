#!/usr/bin/env bash

AUTH_RESPONSE=$(curl -s 'http://localhost:3001/rest/user/login' -H 'Content-Type: application/json' --data-raw '{"email":"test@test.com","password":"testtest"}')
export JS_AUTH_TOKEN=$(jq -r .authentication.token <<< "${AUTH_RESPONSE}")

if [[ -z $JS_AUTH_TOKEN ]] ; then
  echo "ERROR: No authentication token received"
  return 1
else
  echo "SUCCESS: JS_AUTH_TOKEN=${JS_AUTH_TOKEN}"
  return 0
fi
