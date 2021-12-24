FROM python:latest as python

RUN apt-get update
RUN apt-get install -y vim
COPY ./vim.config /root/.vimrc
