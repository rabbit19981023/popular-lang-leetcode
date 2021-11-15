# Leetcode Solutions Implemented in Popular Languages

This project is just for me to practice various programming languages.

Language List:

- [x] Python
- [x] TypeScript (Node.js)
- [x] Go
- [x] Rust
- [x] C#
- [x] Java
- [x] PHP
- [x] C++

## Set Up Development Environment via `Docker`

> Make sure that `Docker Desktop` has been already installed in your machine!!

## Permission Issues

> This issue occured while running the docker container as `root`.

If you create some directories or files inside docker container, they may be owned by `root`.

To solve the permission problem, please run:

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
$ cd ./tests
$ python -m unittest -v
````

> You can have a Python src like this:

```python
# `./src/sum.py`

class Sum:
    def do(self, a: int, b: int) -> int:
        return a + b
```

> And you can have a Python test like this:

```python
# `./tests/test_sum.py`

# ---- To make source files can be found by Python ---- #
import os
import sys

test_file_dir = os.path.dirname(__file__)
src_file_dir = os.path.dirname(test_file_dir) + "/src"

sys.path.append(src_file_dir)

# ---- Tests ---- #
import unittest
from sum import Sum

class SumTest(unittest.TestCase):
    _sum = Sum()

    def process_test_case(self, _input1: int, _input2: int, expected: int):
        actual = self._sum.do(_input1, _input2)
        self.assertEqual(actual, expected)

    def test_sum_of_two_given_numbers(self):
        _input1 = 1
        _input2 = 4
        expected = 5

        self.process_test_case(_input1, _input2, expected)
```

> Finally, the project structure should be like this:

```bash
-- ./
---- src/
------ sum.py
---- tests/
------ test_sum.py
```

> Install python modules globally:

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
$ cd ./src
$ tsc <ts-src>
```

Run the tests:

```bash
$ cd ./tests
$ jest --coverage
```

> Init the project via `Npm` in `./`:

```bash
$ npm init -y
```

> You can have a TypeScript src like this:

```typescript
// `./src/sum.ts`

class Sum {
    public do(a: number, b: number): number {
        return a + b;
    }
}

export { Sum };
```

> And you can have a JavaScript test like this:

```javascript
// `./tests/sum.test.js`

const { Sum } = require('../src/sum');
const sum = new Sum();

const processTestCase = (input1, input2, expected) => {
    const actual = sum.do(input1, input2);
    expect(actual).toBe(expected);
}

test("Test: sum of two given numbers", () => {
    const input1 = 1;
    const input2 = 4;
    const expected = 5;

    processTestCase(input1, input2, expected);
})
```

> Create a `jest.config.js` for `Jest`:

```javascript
// ./tests/jest.config.js

const config = {
  verbose: true,
};

module.exports = config;
```

> Finally, the project structure should be like this:

```bash
-- ./
---- src/
------ sum.ts
------ sum.js # <----- compiled js file (.ts -> .js)
---- tests/
------ sum.test.js
------ jest.config.js
---- package.json
```

> Install the project dependencies listed in `./package.json`:

```bash
$ npm install
```

> Install project dependencies:

```bash
$ npm install [package1, package2 ...]
```

> Install project dev-dependencies:

```bash
$ npm install --save-dev [package1, package2 ...]
```

> Remove project dependencies:

```bash
$ npm uninstall [package1, package2 ...]
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
$ cd ./tests
$ go test -v
```

> Init the project in `./` via `go-mod`:

```bash
$ go mod init <project-name>
```

> You can have a Go src like this:

```golang
// `./src/sum.go`

package solution

// first letter must be `capital` to make it `public` (be available for other go files)
func Sum(a int, b int) int {
    return a + b
}
```

> And you can have a Go test like this:

```golang
// `./tests/sum_test.go`

package tests

import (
    "testing"
    "github.com/stretchr/testify/assert"
    "<project-name>/src" // <----- follow the project structure
)

func processTestCase(t *testing.T, input1 int, input2 int, expected int) {
    actual := solution.Sum(input1, input2)
    assert.Equal(t, expected, actual)
}

// first letter must be `capital` to make it can be found by `go-test`
func Test_sum_of_two_given_numbers(t *testing.T) {
    input1 := 1
    input2 := 4
    expected := 5

    processTestCase(t, input1, input2, expected)
}
```

> Get missing and remove unused modules:

```bash
$ go mod tidy
```

> Finally, the project structure should be like this:

```bash
-- ./
---- src/
------ sum.go
---- tests/
------ sum_test.go
---- go.mod
---- go.sum
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
$ cargo test
```

> Init the project via `Cargo` in `./`:

```bash
$ cargo init
```

> Create a new Rust project via `Cargo`:

```bash
$ cargo new <project-name>
```

> Remove default Git files:

```bash
$ rm -r .git/
$ rm -f .gitignore
```

> After init, your `./Cargo.toml` may look like this:

```toml
[package]
name = "<project-name>"
version = "0.1.0"
edition = "2021"

# See more keys and their definitions at https://doc.rust-lang.org/cargo/reference/manifest.html

[dependencies]

```

> You can have a Rust src like this:

```rust
// `./src/lib.rs` # <----- not `./src/main.rs`!!

pub struct Sum { }

impl Sum {
    pub fn new() -> Sum {
        return Sum { };
    }

    pub fn _do(&self ,a: &i32, b: &i32) -> i32 {
        return a + b;
    }
}
```

> And you can have a Rust test like this:

```rust
// `./tests/sum_test.rs`

use <project-name>::Sum;

fn process_test_case(input1: &i32, input2: &i32, expected: &i32) {
    let sum: Sum = Sum::new();
    let actual: i32 = sum._do(input1, input2);
    assert_eq!(&actual, expected);
}

#[test]
fn sum_of_two_given_numbers() {
    let input1: i32 = 1;
    let input2: i32 = 4;
    let expected: i32 = 5;

    process_test_case(&input1, &input2, &expected);
}
```

> Finally, the project structure should be look like this:

```bash
-- ./
---- src/
------ main.rs
------ lib.rs
---- tests/
------ sum_test.rs
---- Cargo.toml
---- Cargo.lock
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

> Init a `console` project in `./src`:

```bash
$ dotnet new console -o src/
```

> Remove the default entry program:

```bash
$ rm -f ./src/Program.cs
```

> Init a `mstest` project in `./tests`:

```bash
$ dotnet new mstest -o tests/
```

> Remove the default test:

```bash
$ rm -f ./tests/UnitTest1.cs
```

> You can have a C# src like this:

```csharp
// `./src/Sum.cs` # <----- first letter is `capital`

namespace Leetcode
{
    public class Sum
    {
        static void Main(string[] args)
        {
        }

        public int Do(int a, int b)
        {
            return a + b;
        }
    }
}
```

> And you can have a C# test like this:

```csharp
// `./tests/SumTest.cs` # <----- first letter is `capital`

using Microsoft.VisualStudio.TestTools.UnitTesting;
using Leetcode;

namespace LeetcodeTest
{
    [TestClass]
    public class SumTest
    {
        Sum sum = new Sum();

        private void ProcessTestCase(int input1, int input2, int expected)
        {
            int actual = sum.Do(input1, input2);
            Assert.AreEqual(expected, actual);
        }

        [TestMethod]
        public void have_longest_common_prefix()
        {
            int input1 = 1;
            int input2 = 4;
            int expected = 5;

            ProcessTestCase(input1, input2, expected);
        }
    }
}
```

> Finally, the project structure will be look like this:

```bash
-- ./
---- <project-name>.sln
---- src/
------ Sum.cs
------ src.csproj
---- tests/
------ SumTest.cs
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

Run the tests:

```bash
$ mvn test
```

> Init the project via `Maven` in `./<project-name>`:

```bash
$ mvn archetype:generate \
    -DgroupId=<com.company.app> \ # it will be project structure
    -DartifactId=<project-name> \
    -DarchetypeArtifactId=maven-archetype-quickstart \ # Maven template
    -DarchetypeVersion=1.4 \ Maven template version
    -DinteractiveMode=false
```

> You can have a Java src like this:

```java
// `./<project-name>/src/main/java/<com>/<company>/<app>/App.java`

package <com.company.app>;

public class App
{
    public static void main( String[] args )
    {
    }
}

class Sum
{
    public int _do(int a, int b) {
        return a + b;
    }
}
```

> And you can have a Java test like this:

```java
// `./<project-name>/src/test/java/<com>/<company>/<app>/AppTest.java`

package <com.company.app>; // this package include class: Sum

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest
{
    Sum sum = new Sum();

    private void process_test_case(int input1, int input2, int expected) {
        int actual = sum._do(input1, input2);
        assertEquals(expected, actual);
    }

    @Test
    public void sum_of_two_given_numbers() {
        int input1 = 1;
        int input2 = 4;
        int expected = 5;

        process_test_case(input1, input2, expected);
    }
}
```

> Finally, the project structure should be like this:

```bash
-- ./<project-name>
---- src/
------ main/
-------- java/
---------- <com>/
------------ <company>/
-------------- <app>/
---------------- App.java
------ test/
-------- java/
---------- <com>/
------------ <company>/
-------------- <app>/
---------------- AppTest.java
---- pom.xml
```

> Compile and bundle the whole project (Use `Maven`):

```bash
$ cd ./<project-name>
$ mvn package
```

> Run the compiled Java Class within `.jar` binary:

```bash
$ cd ./<project-name>
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

Build the docker image for PHP:

```bash
$ cd Docker
$ sudo docker build -f php.dockerfile -t leetcode/php:latest ./
```

Run and get into the PHP container:

```bash
$ sudo docker run \
    --rm \ # remove the container after exit it
    -it \ # get into the container
    -w "/opt/leetcode" \ # set working dir
    -v "<php-dir>:/opt/leetcode" \ # mount host dir/files to container inside
    leetcode/php:latest \ # PHP image
    /bin/bash # run the command after get into the container
```

Generating `./vendor/autoload.php` to autoloading PHP classes:

```bash
$ composer dump-autoload
```

Run the tests:

```bash
$ phpunit tests --testdox
```

> Init the project via `Composer` in `./`:

```bash
$ composer init # by answering interactive questions
```

> After init, your `./composer.json` may look like this:

```json
{
    "name": "<vendor>/<project-name>",
    "autoload": {
        "psr-4": {
            "<Vendor>\\<Project-name>\\": "src/"
        }
    },
    "require": {}
}

```

> You can have a PHP src like this:

```php
// `./src/Sum.php` # <----- first letter is capital

<?php

namespace <Vendor>\<Project-name>;

final class Sum # <----- class name need to match the file name
{
    final static function do(int $a, int $b): int {
        return $a + $b;
    }
}
```

> And you can have a PHP test like this:

```php
// `./tests/SumTest.php` # <----- first letter is capital

<?php

require 'vendor/autoload.php'; # <----- import autoloaded classes

use PHPUnit\Framework\TestCase;
use <Vendor>\<Project-name>\Sum;

final class SumTest extends TestCase
{
    public function process_test_case(int $input1, int $input2, int $expected): void
    {
        $actual = Sum::do($input1, $input2);
        $this->assertEquals($expected, $actual);
    }

    public function test_sum_of_two_given_numbers(): void # must start with `test*()`
    {
        $input1 = 1;
        $input2 = 4;
        $expected = 5;

        $this->process_test_case($input1, $input2, $expected);
    }
}
```

> Finally, the project structure should be like this:

```bash
-- ./
---- vendor/
------ autoload.php
---- src/
------ Sum.php
---- tests/
------ SumTest.php
---- composer.json
```

> Install the project dependencies listed in `./composer.lock`:

```bash
$ composer install
```

> Install project dependencies:

```bash
$ composer require [package1, package2 ...]
```

> Install project dev-dependencies:

```bash
$ composer require --dev [package1, package2 ...]
```

> Remove project dependencies:

```bash
$ composer remove [package1, package2 ...]
```

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

Build the whole project via `CMake`:

```bash
$ cmake -S ./ -B build # generating cmake config files into ./build
$ cmake --build build # compile the whole project into ./build
```

Run the tests:

```bash
$ cd ./build && ctest

# Or just run:
$ ./build/<test-binary>
```

> You can have a C++ src like this:

```cpp
// `./src/sum.h`

class Sum {
public:
    int _do(int a, int b) {
        return a + b;
    }
};

/** DO NOT declare main function, it may make GoogleTest can't find the Tests **/
// int main(void) {
//     return 0;
// };
```

> And you can have a C++ test like this:

```cpp
// `./tests/sum_test.cc`

#include <gtest/gtest.h>
#include "../src/sum.h"

void processTestCase(int input1, int input2, int expected) {
    Sum* sum_ptr = new Sum();

    // since `sum_ptr` is a pointer which points to Sum class
    // just use `->` to access the class member
    int actual = sum_ptr->_do(input1, input2);
    ASSERT_EQ(actual, expected);
}

TEST(SumTest, SumOfTwoGivenNumbers) {
    int input1 = 1;
    int input2 = 4;
    int expected = 5;

    processTestCase(input1, input2, expected);
}
```

> Create `./CMakeLists.txt` for `CMake` to build the project:

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

# links `<test-binary>` with GoogleTest entry point (`gtest_main`)
target_link_libraries(
    <test-binary>
    gtest_main
)

# to make CMake Test Runner (`ctest`) to find the tests included in `test-binary`
include(GoogleTest)
gtest_discover_tests(<test-binary>)
```

> Finally, the project structure should be like this:

```bash
-- ./
---- src/
------ sum.h
---- tests/
------ sum_test.cc
---- CMakeLists.txt
```

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
