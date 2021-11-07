cmake_minimum_required(VERSION 3.14)
project(leetcode)

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

# declare the C++ test binary we want to build (`longest_common_prefix_test`)
add_executable(
	longest_common_prefix_test
	./tests/longest_common_prefix_test.cc
)

# links `longest_common_prefix_test` into GoogleTest(`gtest_main`)
target_link_libraries(
	longest_common_prefix_test
	gtest_main
)

# to make CMake Test Runner (`ctest`) to find the tests included in `longest_common_prefix_test`
include(GoogleTest)
gtest_discover_tests(longest_common_prefix_test)
