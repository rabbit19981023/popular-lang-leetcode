FROM openjdk:17-jdk-buster as debian-based-java-sdk

RUN curl https://dlcdn.apache.org/maven/maven-3/3.8.3/binaries/apache-maven-3.8.3-bin.zip --output ./maven.zip \
	&& unzip ./maven.zip -d /opt \
	&& rm -f ./maven.zip

ENV PATH="$PATH:/opt/apache-maven-3.8.3/bin"
