FROM node:lts as nodejs

RUN apt-get update
RUN apt-get install -y vim
COPY ./vim.config /root/.vimrc
RUN mkdir -p ~/.vim/pack/typescript/start \
    && git clone https://github.com/leafgarland/typescript-vim.git ~/.vim/pack/typescript/start/typescript-vim

RUN npm install -g typescript
RUN npm install -g jest
