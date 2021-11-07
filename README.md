# Leetcode Solutions Implemented in Popular Languages

This project is just for me to practice various programming languages.

Language List:

- [x] Python
- [x] TypeScript (Node.js)
- [x] Go
- [x] Rust
- [x] C#
- [x] Java
- [ ] PHP
- [x] C++

## Set Up Development Environment via Docker

> Make sure that `Docker Desktop` has been already installed in your machine!!

## Permission Issues

> This issue occured while running the docker container as `root`.

If you create some directories or files inside docker container, they may be owned by `root`.

To solve the problem, please run:

```bash
# on your host, in project root dir
$ sudo chown -R 1000:1000 ./

# inside docker container, in project root dir
$ chown -R 1000:1000 ./
```

### Python

Build the docker image for Python:

```bash
$ cd Docker
$ sudo docker build -f python.dockerfile -t leetcode/python:latest ./
```

Run and get into the Python container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/leetcode" \ # set working dir
    -v "<python-dir>:/opt/leetcode" \ # mount host dir/files to container inside
    leetcode/python:latest \ # Python image
    /bin/bash # run the command after get into the container
```

Run the tests:

```bash
$ cd python/tests
$ python -m unittest -v test_longest_common_prefix.TestCases
````

> Install Python packages:

```bash
$ pip install [module1, module2 ...]
```

> Run source code:

```bash
$ python <python-src>
```

### TypeScript (Node.js)

Build the docker image for Node.js:

```bash
$ cd Docker
$ sudo docker build -f nodejs.dockerfile -t leetcode/nodejs:latest ./
```

Run and get into the Node.js container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/leetcode" # set working dir
    -v "<nodejs-dir>:/opt/leetcode" # mount host dir/files to container inside
    leetcode/nodejs:latest \ # Node.js image
    /bin/bash # run the command after get into the container
```

Compile source code:

```bash
$ cd nodejs/src
$ tsc <ts-src>
```

Run the tests:

```bash
$ cd nodejs/tests
$ jest --coverage
```

> Create a `jest.config.js` for `Jest`:

```javascript
// nodejs/tests/jest.config.js

const config = {
  verbose: true,
};

module.exports = config;
```

> Init the Node.js project in `./`:

```bash
$ npm init -y
```

> Install Node.js packages:

```bash
$ npm install [module1, module2 ...]
```

> Run `Npm` scripts defined in `package.json`:

```bash
$ npm run <custom-script>
```

> Run compiled `.js` file (`.ts` -> `.js`):

```bash
$ node <compiled-js-file>
```

### Go

Build the docker image for Go:

```bash
$ cd Docker
$ sudo docker build -f golang.dockerfile -t leetcode/golang:latest ./
```

Run and get into the Go container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/leetcode" \ # set working dir
    -v "<golang-dir>:/opt/leetcode" \ # mount host dir/files to container inside
    leetcode/golang:latest \ # Go image
    /bin/bash # run the command after get into the container
```

Run the tests:

```bash
$ cd golang/tests
$ go test -v longest_common_prefix_test.go
```

> Init the Go project in `./`:

```bash
$ go mod init <project-name>
```

> Get missing and remove unused modules:

```bash
$ go mod tidy
```

> Run source code:

```bash
$ go run <go-src>
```

### Rust

Build the docker image for Rust:

```bash
$ cd Docker
$ sudo docker build -f rust.dockerfile -t leetcode/rust:latest ./
```

Run and get into the Rust container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/leetcode" \ # set working dir
    -v "<rust-dir>:/opt/leetcode" \ # mount host dir/files to container inside
    leetcode/rust:latest \ # Rust image
    /bin/bash # run the command after get into the container
```

Run the tests:

```bash
# in project root dir
$ cargo test
```

> Init the Rust project in `./`:

```bash
$ cargo init
```

> Create a new Rust project:

```bash
$ cargo new <project>
```

> Remove Git files:

```bash
$ rm -r .git/
$ rm -f .gitignore
```

> Compile the Rust source code:

```bash
$ rustc <rust-src>
```

> Run the Rust binary executable:

```bash
$ ./<rust-binary>
```

### C#

Build the docker image for C#:

```bash
$ cd Docker
$ sudo docker build -f csharp.dockerfile -t leetcode/csharp:latest ./
```

Run and get into the C# container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/leetcode" \ # set working dir
    -v "<csharp-dir>:/opt/leetcode" \ # mount host dir/files to container inside
    leetcode/csharp:latest \ # C# image
    /bin/bash # run the command after get into the container
```

Run the tests:

```bash
$ dotnet test
```

> Init a `solution` for the whole project in `./`:

```bash
$ dotnet new sln
```

> Init a `console` project in `./src/`:

```bash
$ dotnet new console -o src/
```

> Removing the default entry program:

```bash
$ rm -f ./src/Program.cs
```

> Init a `mstest` project in `./tests/`:

```bash
$ dotnet new mstest -o tests/
```

> The whole structure will be look like this:

```bash
-- ./
---- leetcode.sln
---- src/
------ solution.cs
------ src.csproj
---- tests/
------ Tests.cs
------ tests.csproj
```

> Add `console` project & `mstest` project into `solution`:

```bash
$ dotnet sln add ./src/src.csproj ./tests/tests.csproj
```

> In `tests.csproj`, we add a reference project `src.csproj` into it, to make source code can be invoked in tests:

```bash
$ dotnet add ./tests/tests.csproj reference ./src/src.csproj
```

> Run the C# code:

```bash
# in project dir
$ dotnet run

# or use `--project` flag to specify project path
$ dotnet run --project=<project-path>
```

### Java

Build the docker image for Java:

```bash
$ cd Docker
$ sudo docker build -f java.dockerfile -t leetcode/java:latest ./
```

Run and get into the Java container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/leetcode" \ # set working dir
    -v "<java-dir>:/opt/leetcode" \ # mount host dir/files to container inside
    leetcode/java:latest \ # Java image
    /bin/bash # run the command after get into the container
```

> Everytime you run the container, it may take minutes to download dependencies & plugins for `Maven` which is a package manager for Java.

Run the tests:

```bash
$ mvn test
```

> Init a Java project via `Moven`:

```bash
$ mvn archetype:generate \
    -DgroupId=<com.company.app> \ # it will be project structure
    -DartifactId=<project-name> \
    -DarchetypeArtifactId=maven-archetype-quickstart \ # Maven template
    -DarchetypeVersion=1.4 \ Maven template version
    -DinteractiveMode=false
```

> Compile and bundle the whole project (Use `Moven`):

```bash
$ cd java/<project-name>
$ mvn package
```

> Run the compiled Java Class within `.jar` binary:

```bash
$ cd java/<project-name>
$ java -cp ./target/<project-name>-1.0-SNAPSHOT.jar <com.company.app>.App
```

> Compile the Java source code:

```bash
$ javac <java-src>
```

> Run the Java binary executable Class (`.class` file):

```bash
$ java Main # without .class extension
```

### PHP


### C++

Build the docker image for C++:

```bash
$ cd Docker
$ sudo docker build -f cpp.dockerfile -t leetcode/cpp:latest ./
```

Run and get into the C++ container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/leetcode" \ # set working dir
    -v "<cpp-dir>:/opt/leetcode" \ # mount host dir/files to container inside
    leetcode/cpp:latest \ # C++ image
    /bin/bash # run the command after get into the container
```

Build the CMake project:

```bash
$ cmake -S . -B build
$ cmake --build build
```

Run the tests:

```bash
$ cd ./build && ctest

# Or just run:
$ ./build/<test-binary>
```

> Create a file named `CMakeLists.txt`:

```bash
# `./CMakeLists.txt`:

cmake_minimum_required(VERSION 3.14)
project(<project-name>)

# GoogleTest requires at least C++11
set(CMAKE_CXX_STANDARD 11)

# use `FetchContent` CMake Module
include(FetchContent)

# get GoogleTest from github as CMake project dependency
FetchContent_Declare(
    googletest
    URL https://github.com/google/googletest/archive/609281088cfefc76f9d0ce82e1ff6c30cc3591e5.zip
)
FetchContent_MakeAvailable(googletest)

# Enable testing in CMake
enable_testing()

# declare the C++ test binary we want to build (`<test-binary>`)
add_executable(
    <test-binary>
    <test-src-path>
)

# links `<test-binary>` into GoogleTest entry point (`gtest_main`)
target_link_libraries(
    <test-binary>
    gtest_main
)

# to make CMake Test Runner (`ctest`) to find the tests included in `test-binary`
include(GoogleTest)
gtest_discover_tests(<test-binary>)
```

> **Attention: Dont't use `main` function in `<be-tested-src.h>`, or it may make `GoogleTest` unable to find tests.**

> Official Tutorial for GoogleTest:

- [Building with CMake - GoogleTest](https://google.github.io/googletest/quickstart-cmake.html)

> Compile the C++ source code:

```bash
$ clang++ -o <cpp-binary> <cpp-src>
```

> Run the C++ binary executable:

```bash
$ ./<cpp-binary>
```
