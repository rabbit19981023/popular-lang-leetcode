FROM node:latest as nodejs

RUN apt-get update && apt-get install -y
RUN npm install -g typescript
