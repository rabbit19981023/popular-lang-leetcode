package company.app;

import java.util.Map;
import java.util.HashMap;

public class TwoSum
{
    public int[] _do(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int diff = target - current;

            if (map.containsKey(current)) {
                return new int[] {map.get(current), i};
            }

            map.put(diff, i);
        }

        return new int[] {};
    }
}
