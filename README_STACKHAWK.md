# Scanning with StackHawk

Here's a quick rundown of how to run a StackHawk scan against Juice Shop.

In this fork of the Juice Shop repo, we have added a couple of files.
 * `README_STACKHAWK.md` - This file.
 * `stackhawk.yml` - A working StackHawk scan configuration file. You should update `app.applicationId` to match your App ID for Juice Shop in your StackHawk org.
 * `stackhawk_create_user.sh` - A shell script to create the test user account, `test@test.com`.
 * `stackhawk_auth_token.sh` - A shell script to login to Juice Shop and fetch a JWT, which is used to authenticate the scanner to Juice Shop.

This guide assumes that you have:
 * Set up prereqs for Cypress
   * [Amazon Linux](README_AMAZON_LINUX.md)
 * Installed the [StackHawk CLI](https://docs.stackhawk.com/stackhawk-cli/)
 * Exported your StackHawk API key as the environment variable `API_KEY`
 * Exported your Juice Shop App ID from StackHawk as `JS_APP_ID`

> NOTE: Before scanning Juice Shop, you should start up a [`screen`](https://www.baeldung.com/linux/screen-command) session so that you can detach and re-attach to your session from your laptop. The scan may take 10 hours or longer to complete.

Install Juice Shop dependencies
```shell
npm install
```

Build and run Juice Shop as a Docker Container
```shell
docker-compose up --build --detach
```

Or if you prefer, run Juice Shop in the background using NPM
```shell
npm start &
```

Create the test user, test@test,com:
```shell
./stackhawk_create_user.sh
```

Fetch a JWT for test@test.com and export it as JS_AUTH_TOKEN - will be used for StackHawk authenticated scanning
```shell
source ./stackhawk_auth_token.sh
```

Run HawkScan
```shell
hawk scan
```
