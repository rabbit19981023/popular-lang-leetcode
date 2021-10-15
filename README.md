# Leetcode Solutions Implemented in Popular Languages

This project is just for me to practice various programming languages.

Language List:

[x] Python
[x] TypeScript (Node.js)
[x] Go
[x] C#
[x] Java

## Set Up Development Environment via Docker

> Make sure Docker has been already installed in your machine!!

### Python

Build the docker image for python:

```bash
$ cd Docker
$ sudo docker build -f python.dockerfile -t leetcode/python:latest ./
```

Run and get into the python container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/test" \ # set working directory
    -v "<python-src-dir>:/opt/test" \ # mount host dir/files to container inside
    leetcode/python:latest \ # python image
    /bin/bash # run the command after get into the container
```

Run the python code:

```bash
$ python <python-src-file>
```

### TypeScript (Node.js)

Build the docker image for nodejs:

```bash
$ cd Docker
$ sudo docker build -f nodejs.dockerfile -t leetcode/nodejs:latest ./
```

Run and get into the nodejs container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/test" # set working directory
    -v "<node-src-dir>:/opt/test" # mount host dir/files to container inside
    leetcode/nodejs:latest \ # nodejs image
    /bin/bash # run the command after get into the container
```

Compile the typescript source code:

```bash
$ tsc <ts-src-file>
```

Run the compiled code (javascript):

```bash
$ node <js-src-file>
```

### Go

Build the docker image for golang:

```bash
$ cd Docker
$ sudo docker build -f go.dockerfile -t leetcode/go:latest ./
```

Run and get into the golang container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/test" \ # set working directory
    -v "<go-src-dir>:/opt/test" \ # mount host dir/files to container inside
    leetcode/go:latest \ # golang image
    /bin/bash # run the command after get into the container
```

Run the golang code:

```bash
$ go run <go-src-file>
```

### C#

Build the docker image for csharp:

```bash
$ cd Docker
$ sudo docker build -f csharp.dockerfile -t leetcode/csharp:latest ./
```

Run and get into the csharp container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/test" \ # set working directory
    -v "<csharp-src-dir>:/opt/test" \ # mount host dir/files to container inside
    leetcode/csharp:latest \ # csharp image
    /bin/bash # run the command after get into the container
```

Set up csharp project:

```bash
$ dotnet new console # will init project in current working dir
```

Run the csharp code:

```bash
$ dotnet run <csharp-src-file>
```

### Java

Build the docker image for java:

```bash
$ cd Docker
$ sudo docker build -f java.dockerfile -t leetcode/java:latest ./
```

Run and get into the java container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/test" \ # set working directory
    -v "<java-src-dir>:/opt/test" \ # mount host dir/files to container inside
    leetcode/java:latest \ # java image
    /bin/bash # run the command after get into the container
```

Compile the java source code:

```bash
$ javac <java-src-file>
```

Run the java binary executable (`.class` file):

```bash
$ java Main # without .class extension
```
