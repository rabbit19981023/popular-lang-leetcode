using System;

namespace LeetCode
{
    public class Solution
    {
        static void Main(string[] args)
        {
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

        private bool IsValid(string[] strs)
        {
            return ! (strs == null || strs.Length == 0);
        }

        private int GetMinLen(string[] strs)
        {
            int minLen = strs[0].Length;

            for (int i = 0; i < strs.Length; i++) {
                if (strs[i].Length < minLen) {
                    minLen = strs[i].Length;
                }
            }

            return minLen;
        }

        private bool IsCommonPrefix(int mid, string[] strs)
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
}
