# Scanning with StackHawk

Here's a quick rundown of how to run a StackHawk scan against Juice Shop.

In this fork of the Juice Shop repo, we have added a couple of files.
 * `README_STACKHAWK.md` - This file.
 * `stackhawk.yml` - A working StackHawk scan configuration file. You should update `app.applicationId` to match your App ID for Juice Shop in your StackHawk org.
 * `stackhawk_auth_token.sh` - A shell script to login to Juice Shop and fetch a JWT, which is used to authenticate the scanner to Juice Shop.

This guide assumes that you have:
 * Installed the [StackHawk CLI](https://docs.stackhawk.com/stackhawk-cli/)
 * Exported your StackHawk API key as the environment variable `API_KEY`
 * Exported your Juice Shop App ID from StackHawk as `JS_APP_ID`

```shell
# Install Juice Shop dependencies
npm install

# Run Juice Shop in the background
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
