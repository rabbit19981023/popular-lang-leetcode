FROM ubuntu:latest as ubuntu

RUN apt-get update && apt-get upgrade -y

RUN DEBIAN_FRONTEND=noninteractive \
	apt-get install -y \
	clang \
	cmake
