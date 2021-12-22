FROM node:lts as nodejs

RUN npm install -g typescript
RUN npm install -g jest
