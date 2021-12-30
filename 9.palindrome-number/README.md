# 9. Palindrome Number: Easy

## Description

Given an integer `x`, return `true` if `x` is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

## Example 1

```bash
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
```

## Example 2

```bash
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```

## Example 3

```bash
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
```

## Constraints

```math
-2^31 <= x <= 2^31 - 1
```

## Solution

## Complexity Analysis

Time complexity : <img src="https://render.githubusercontent.com/render/math?math=O(log_10(n))">. Because we divided the input by 10 for every iteration.

Space complexity : `O(1)`.
