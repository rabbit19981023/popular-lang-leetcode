FROM ubuntu:latest as ubuntu

RUN apt-get update
RUN apt-get install -y vim
COPY ./vim.config /root/.vimrc

RUN DEBIAN_FRONTEND=noninteractive \
	apt-get install -y \
	clang \
	cmake
