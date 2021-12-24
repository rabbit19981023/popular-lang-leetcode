FROM mcr.microsoft.com/dotnet/sdk:latest as csharp

RUN apt-get update
RUN apt-get install -y vim
COPY ./vim.config /root/.vimrc
