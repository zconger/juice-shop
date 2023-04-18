# Setup for Amazon Linux

This is a guide to setting up an Amazon Linux system to build, run, and scan Juice Shop with StackHawk.

Our test system for creating this document had the following specifications:
 * m6a.large EC2 instance
 * 2 vCPUs
 * 8 GB RAM
 * 16 GB disk
 * Amazon Linux release 2023 (Amazon Linux)

## Install prerequisite software

Install `git`, `nodejs`, `java`, the X virtual framebuffer (`Xvfb`), and several other packages to support running Juice Shop, its Cypress tests, and StackHawk.

```shell
# Install prerequisite Yum packages
sudo yum install -y nodejs git java-17-amazon-corretto jq \
  Xvfb pango pango pango-devel libXrandr libXrandr-devel \
  libXcursor libXcursor-devel cups-libs \
  atk-devel at-spi2-atk gtk3 mesa-libgbm-devel docker

# Install Docker Compose
sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
sudo usermod -a -G docker ec2-user

# Install the StackHawk `hawk` CLI
curl -v https://download.stackhawk.com/hawk/cli/hawk-3.0.0.zip -o hawk-3.0.0.zip
unzip hawk-3.0.0.zip
echo "export PATH=$HOME/hawk-3.0.0:$PATH" >> ~/.bash_profile
source ~/.bash_profile
```
