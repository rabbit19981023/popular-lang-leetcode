﻿using System;

namespace LeetCode
{
    class Solution
    {
        static void Main(string[] args)
        {
            Test test_01 = new Test{ Strs = new string[] { "flower","flow","flight" } };
            Test test_02 = new Test{ Strs = new string[] { "dog","racecar","car" } };

            Solution solution = new Solution();

            string result_01 = solution.LongestCommonPrefix(test_01.Strs);
            string result_02 = solution.LongestCommonPrefix(test_02.Strs);

            Console.WriteLine();
            Console.WriteLine("Expected: 'fl'" + "\n" + "Output: " + result_01);
            Console.WriteLine();
            
            Console.WriteLine("Expected: ''" + "\n" + "Output: " + result_02);
            Console.WriteLine();
        }

        public string LongestCommonPrefix(string[] strs)
        {
            if (! IsValid(strs)) {
                return "";
            }

            int low = 1;
            int high = GetMinLen(strs);
            int mid;

            while (low <= high) {
                mid = (low + high) / 2;
                
                if (IsCommonPrefix(mid, strs)) {
                    low = mid + 1;
                    continue;
                }

                high = mid - 1;
            }

            int result = (low + high) / 2;
            return strs[0].Substring(0, result);
        }

        public bool IsValid(string[] strs)
        {
            return ! (strs == null || strs.Length == 0);
        }

        public int GetMinLen(string[] strs)
        {
            int minLen = strs[0].Length;

            for (int i = 0; i < strs.Length; i++) {
                if (strs[i].Length < minLen) {
                    minLen = strs[i].Length;
                }
            }

            return minLen;
        }

        public bool IsCommonPrefix(int mid, string[] strs)
        {
            string prefix = strs[0].Substring(0, mid);

            for (int i = 1; i < strs.Length; i++) {
                if (! strs[i].StartsWith(prefix)) {
                    return false;
                }
            }

            return true;
        }
    }

    class Test
    {
       public string[] Strs { get; set; }
    }
}
