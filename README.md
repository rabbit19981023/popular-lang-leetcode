# Leetcode Solutions Implemented in Popular Languages

This project is just for me to practice various programming languages.

Language List:

- [x] [Python](#python)
- [x] [TypeScript (Node.js)](#typescript)
- [x] [Go](#go)
- [x] [Rust](#rust)
- [x] [C#](#csharp)
- [x] [Java](#java)
- [x] [PHP](#php)
- [x] [C++](#cpp)

## Set Up Development Environment via `Docker`

> Make sure that `Docker Desktop` has been already installed in your machine!!

## Permission Issues

> This issue occured while running the docker container as `root`.

If you create some files inside docker container, they may be owned by `root`.

To solve the permission problem, please run:

```bash
# on your host, in project root dir
$ sudo chown -R 1000:1000 ./

# inside docker container, in project root dir
$ chown -R 1000:1000 ./
```

<details>
  <summary>
    <span id="python">Python</span>
  </summary>

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
$ cd <python-dir>   # ATTENTION: <python-dir> is your python project root
$ python -m unittest -v
```

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

import unittest
from src.sum import Sum

class SumTest(unittest.TestCase):
  _sum = Sum()

  def test_sum_of_two_given_numbers(self):
    inputs = {
      "a": 1,
      "b": 4
    }
    expected = 5

    self.process_test_case(inputs, expected)

  def process_test_case(self, inputs: dict, expected: int):
    actual = self._sum.do(inputs["a"], inputs["b"])
    self.assertEqual(actual, expected)
```

> Finally, the project structure should be like this:

```bash
-- ./
---- src/
------ __init__.py    # <- to make src/ dir to be treated as a package
------ sum.py         # <- thanks to ./__init__.py, it will be treated as a module
---- tests/
------ __init__.py    # <- to make tests/ dir to be treated as a package
------ test_sum.py    # <- thanks to ./__init__.py, it will be treated as a module
```

> Install python modules globally:

```bash
$ pip install [module1, module2 ...]
```

> Run source code:

```bash
$ python <python-src>
```
</details>

<details>
  <summary>
    <span id="typescript">TypeScript</span>
  </summary>

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
    return a + b
  }
}

export { Sum }
```

> And you can have a JavaScript test like this:

```javascript
// `./tests/sum.test.js`

const { Sum } = require('../src/sum')

describe('../src/sum.js', () => {
  it("Test: sum of two given numbers", () => {
    const inputs = {
      a: 1,
      b: 4
    }
    const expected = 5

    processTestCase(inputs, expected)
  })
})

const sum = new Sum()

const processTestCase = (inputs, expected) => {
  const actual = sum.do(inputs.a, inputs.b)
  expect(actual).toBe(expected)
}
```

> Create a `jest.config.js` for `Jest`:

```javascript
// ./tests/jest.config.js

const config = {
  // add your own jest config here
};

module.exports = config
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
$ npm install --save [package1, package2 ...]
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
</details>

<details>
  <summary>
    <span id="go">Go</span>
  </summary>

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

type Inputs struct {
  a int
  b int
}

// first letter must be `capital` to make it can be found by `go-test`
func Test_sum_of_two_given_numbers(t *testing.T) {
  var inputs Inputs = Inputs {
    a: 1,
    b: 4,
  }
  expected := 5

  processTestCase(t, inputs, expected)
}

func processTestCase(t *testing.T, inputs Inputs, expected int) {
  actual := solution.Sum(inputs.a, inputs.b)
  assert.Equal(t, expected, actual)
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
</details>

<details>
  <summary>
    <span id="rust">Rust</span>
  </summary>

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
$ cargo init --name <project-name>
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
// `./src/lib.rs` # <----- NOT `./src/main.rs`!! And it MUST BE named with `lib.rs` for cargo-test

pub struct Sum { }

impl Sum {
  pub fn new() -> Sum {
    return Sum { };
  }

  pub fn _do(&self, a: &i32, b: &i32) -> i32 {
    return a + b;
  }
}
```

> And you can have a Rust test like this:

```rust
// `./tests/sum_test.rs`

use <project-name>::Sum;

struct Inputs {
  a: i32,
  b: i32
}

#[test]
fn sum_of_two_given_numbers() {
  let inputs: Inputs = Inputs {
    a: 1,
    b: 4
  };
  let expected: i32 = 5;

  process_test_case(&inputs, &expected);
}

fn process_test_case(inputs: &Inputs, expected: &i32) {
  let sum: Sum = Sum::new();
  let actual: i32 = sum._do(&inputs.a, &inputs.b);
  assert_eq!(&actual, expected);
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
</details>

<details>
  <summary>
    <span id="csharp">C#</span>
  </summary>

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
$ dotnet new console -o ./src
```

> Remove the default entry program:

```bash
$ rm -f ./src/Program.cs
```

> Init a `mstest` project in `./tests`:

```bash
$ dotnet new mstest -o ./tests
```

> Remove the default test:

```bash
$ rm -f ./tests/UnitTest1.cs
```

> Add `console` project & `mstest` project into `solution`:

```bash
$ dotnet sln add ./src/src.csproj ./tests/tests.csproj
```

> In `tests.csproj`, we add a reference project `src.csproj` into it, to make source code can be invoked in tests:

```bash
$ dotnet add ./tests/tests.csproj reference ./src/src.csproj
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

    public class Inputs
    {
      public int A;
      public int B;
    }

    [TestMethod]
    public void sum_of_two_given_numbers()
    {
      Inputs inputs = new Inputs() {
        A = 1,
        B = 4
      };
      int expected = 5;

      ProcessTestCase(inputs, expected);
    }

    private void ProcessTestCase(Inputs inputs, int expected)
    {
      int actual = sum.Do(inputs.A, inputs.B);
      Assert.AreEqual(expected, actual);
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

> Run the C# code:

```bash
$ dotnet run

# or use `--project` flag to specify project path
$ dotnet run --project=<project-path>
```
</details>

<details>
  <summary>
    <span id="java">Java</span>
  </summary>

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
// `./<project-name>/src/main/java/<com>/<company>/<app>/Sum.java`

package <com.company.app>; // follows the maven project structure

public class Sum
{
  public int _do(int a, int b) {
    return a + b;
  }
}
```

> And you can have a Java test like this:

```java
// `./<project-name>/src/test/java/<com>/<company>/<app>/SumTest.java`

package <com.company.app>; // this package include class: Sum

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SumTest
{
  Sum sum = new Sum();

  @Test
  public void sum_of_two_given_numbers()
  {
    Inputs inputs = new Inputs();
    inputs.setA(1)
          .setB(4);

    int expected = 5;

    processTestCase(inputs, expected);
  }

  private void processTestCase(Inputs inputs, int expected)
  {
    int actual = sum._do(inputs.getA(), inputs.getB());
    assertEquals(expected, actual);
  }

  private class Inputs
  {
    private int a;
    private int b;

    public int getA()
    {
      return this.a;
    }

    public int getB()
    {
      return this.b;
    }

    public Inputs setA(int a)
    {
      this.a = a;
      return this;
    }

    public Inputs setB(int b)
    {
      this.b = b;
      return this;
    }
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
---------------- App.java # default file which can be ignored
---------------- Sum.java
------ test/
-------- java/
---------- <com>/
------------ <company>/
-------------- <app>/
---------------- AppTest.java # default file which can be ignored
---------------- SumTest.java
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

> Run the Java source code:

```bash
$ java <java-src>
```

> Compile the Java source code:

```bash
$ javac <java-src>
```

> Run the Java binary executable Class (`*.class` files):

```bash
$ java Main # without .class extension
```
</details>

<details>
  <summary>
    <span id="php">PHP</span>
  </summary>

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
  final public function _do(int $a, int $b): int
  {
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
  public function test_sum_of_two_given_numbers(): void # must start with `test*()`
  {
    $inputs = [
      "a" => 1,
      "b" => 4
    ];
    $expected = 5;

    $this->processTestCase($inputs, $expected);
  }

  private function processTestCase(array $inputs, int $expected): void
  {
    $sum = new Sum();
    $actual = $sum->_do($inputs["a"], $inputs["b"]);
    $this->assertEquals($expected, $actual);
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
</details>

<details>
  <summary>
    <span id="cpp">C++</span>
  </summary>

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
$ cmake --build ./build # compile the whole project into ./build
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
// `./tests/sum_test.cpp`

#include <gtest/gtest.h>
#include "../src/sum.h"

class Inputs {
public:
  int a;
  int b;
};

void processTestCase(Inputs inputs, int expected); // # < --- you must declare the function first, or it cannot be accessed

TEST(SumTest, SumOfTwoGivenNumbers) {
  Inputs inputs {
    .a = 1,
    .b = 4
  };
  int expected = 5;

  processTestCase(inputs, expected);
}

Sum sum;

void processTestCase(Inputs inputs, int expected) {
  int actual = sum._do(inputs.a, inputs.b);
  ASSERT_EQ(actual, expected);
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
------ sum_test.cpp
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
</details>
