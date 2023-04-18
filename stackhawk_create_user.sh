#!/usr/bin/env bash

curl 'http://localhost:3000/api/Users/' \
  -H 'Content-Type: application/json' \
  --data-raw '{"email":"test@test.com","password":"testtest"}'


#curl 'http://localhost:3000/api/Users/' \
#  -H 'Accept: application/json, text/plain, */*' \
#  -H 'Accept-Language: en-US,en;q=0.9' \
#  -H 'Connection: keep-alive' \
#  -H 'Content-Type: application/json' \
#  -H 'Cookie: language=en; welcomebanner_status=dismiss; cookieconsent_status=dismiss; Idea-99637c87=139c756d-4708-4783-8ada-5c30f9831e87; continueCode=Q9u3hYtEcBIETnCzsnFpfPSjUKuRhwtnclIBT3CwsVFDi4fyS5UyHEunhOtlckImTEC8sqF2ilfQSlUpHYvujjhv3tN4crLIQJTzKCmrsgMFNLi4wfoPSwZUQqHz6uJoh87cl7I6YTQPCM1sboFOqi9Mf1QS7qUoEuxoh2QtwZc3LIYDTNkCMZsX6FPMi5Lfq4SOJU39h2qtkXcvvInvT9Nsn3FaZiyvfbmSqZUNWH1N; io=X9zrD8dnrgmvq1SMAAAA' \
#  -H 'Origin: http://localhost:3000' \
#  -H 'Referer: http://localhost:3000/' \
#  -H 'Sec-Fetch-Dest: empty' \
#  -H 'Sec-Fetch-Mode: cors' \
#  -H 'Sec-Fetch-Site: same-origin' \
#  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36' \
#  -H 'sec-ch-ua: "Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99"' \
#  -H 'sec-ch-ua-mobile: ?0' \
#  -H 'sec-ch-ua-platform: "macOS"' \
#  --data-raw '{"email":"test2@test.com","password":"testtest","passwordRepeat":"testtest","securityQuestion":{"id":1,"question":"Your eldest siblings middle name?","createdAt":"2023-04-18T04:06:26.668Z","updatedAt":"2023-04-18T04:06:26.668Z"},"securityAnswer":"vern"}' \
#  --compressed