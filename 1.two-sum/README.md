# 1. Two Sum: Easy

## Description

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

## Example 1

```bash
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
# Because nums[0] + nums[1] == 9, we return [0, 1].
```

## Example 2

```bash
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

## Example 3

```bash
Input: nums = [3,3], target = 6
Output: [0,1]
```

## Constraints

```bash
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
```

## Solution

`One-pass Hash Table`:

It turns out we can do it in one-pass. While we are iterating and inserting elements into the hash table, we also look back to check if current element's complement already exists in the hash table. If it exists, we have found a solution and return the indices immediately.

## Complexity Analysis

Time complexity: `O(n)`. We traverse the list containing `n` elements only once. Each lookup in the table costs only `O(1)` time.

Space complexity: `O(n)`. The extra space required depends on the number of items stored in the hash table, which stores at most `n` elements.
