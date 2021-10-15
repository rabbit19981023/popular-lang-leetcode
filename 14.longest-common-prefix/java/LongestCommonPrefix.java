class Main
{
    public static void main(String[] args)
    {
        Test test_01 = new Test(new String[] { "flower", "flow", "flight" });
        Test test_02 = new Test(new String[] { "dog", "rececar", "car" });

        Solution solution = new Solution();

        String result_01 = solution.longestCommonPrefix(test_01.strs);
        String result_02 = solution.longestCommonPrefix(test_02.strs);

        System.out.println();
        System.out.println("Expected: 'fl'" + "\n" + "Output: " + result_01);
        System.out.println();
        
        System.out.println("Expected: ''" + "\n" + "Output: " + result_02);
        System.out.println();
    }
}

class Solution
{
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

    public Boolean isValid(String[] strs)
    {
        return (! (strs == null || strs.length == 0)) ? true : false;
    }

    public int getMinLen(String[] strs)
    {
        int minLen = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }

        return minLen;
    }

    public Boolean isCommonPrefix(int mid, String[] strs)
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

class Test
{
    String[] strs;

    public Test(String[] strs) {
        this.strs = strs;
    }
}
