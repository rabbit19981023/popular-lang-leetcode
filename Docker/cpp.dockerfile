FROM ubuntu:latest as ubuntu

RUN apt-get update && apt-get install -y
RUN apt-get install -y clang
