# Scanning with StackHawk

Here's a quick rundown of 

```shell
# Install dependencies
npm install

# Run Juice Shop
npm start &

# Browse to juice shop at http://localhost:3000 and create the test user:
open http://localhost:3000
#   username: test@test.com
#   password: testtest

# Fetch a JWT for test@test.com and export it as JS_AUTH_TOKEN - will be used for StackHawk authenticated scanning
source ./stackhawk_auth_token.sh

# Run HawkScan
hawk scan
```
