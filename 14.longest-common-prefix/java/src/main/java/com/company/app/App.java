package com.company.app;

public class App
{
    public static void main( String[] args )
    {
    }
}

class Solution
{
    /**
     * 
     * @param String[] strs
     * @return String
     * 
     */
    public String longestCommonPrefix(String[] strs)
    {
        if (! isValid(strs)) {
            return "";
        }

        int low = 1;
        int high = getMinLen(strs);
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (isCommonPrefix(mid, strs)) {
                low = mid + 1;
                continue;
            }

            high = mid - 1;
        }

        int result = (low + high) / 2;
        return strs[0].substring(0, result);
    }

    private Boolean isValid(String[] strs)
    {
        return ! (strs == null || strs.length == 0);
    }

    private int getMinLen(String[] strs)
    {
        int minLen = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }

        return minLen;
    }

    private Boolean isCommonPrefix(int mid, String[] strs)
    {
        String prefix = strs[0].substring(0, mid);
        
        for (int i = 1; i < strs.length; i++) {
            if (! strs[i].startsWith(prefix)) {
                return false;
            }
        }

        return true;
    }
}