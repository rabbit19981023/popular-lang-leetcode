# 14. Longest Common Prefix: Easy

## Description

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

## Example 1

```bash
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

## Example 2

```bash
Input: strs = ["dog","racecar","car"]
Output: ""
```

## Constraints

```bash
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
```

## Solution

We will use `Binary Search` to solve this problem.

> Attention: binary search is not the best solution for this problem!

<img src="https://leetcode.com/media/original_images/14_lcp_binary_search.png" width="500px"></img>

Picture Resource: [Longest Common Prefix Solutions - Leetcode](https://leetcode.com/problems/longest-common-prefix/solution/)

## Complexity Analysis

In the worst case we have `n` equal strings with length `m`

Time complexity : `O(S．log m)`, where `S` is the sum of all characters in all strings.

The algorithm makes `log m` iterations, for each of them there are `S = m ． n` comparisons, which gives in total `O(S．log m)` time complexity.

Space complexity : `O(1)`. We only used constant extra space.
