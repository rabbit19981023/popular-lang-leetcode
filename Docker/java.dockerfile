FROM openjdk:jdk-buster as debian-based-java-sdk

RUN apt-get update
RUN apt-get install -y vim
COPY ./vim.config /root/.vimrc

# you need to check the latest version everytime
# official website: https://maven.apache.org/download.cgi
ARG MAVEN_VERSION=3.8.4

RUN curl https://dlcdn.apache.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.zip --output ./maven.zip \
	&& unzip ./maven.zip -d /opt \
	&& rm -f ./maven.zip

ENV PATH="$PATH:/opt/apache-maven-$MAVEN_VERSION/bin"
