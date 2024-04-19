// Time Complexity : O(n) + O(length)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Put the values in a cache- and solve what is the max we can do like a house robber.
 * 
 * The optimized problem is i=minvalue -> maxValue 
 * 
 * Calculate the previous sun and the current running sum  to determine the next steps
 * 
 * How do identify the elements that was choosen to make the maximum sum?
 * 
 * We choose array because we only had one decision parameter?
 * 
 * 
 * 
 */

import java.util.*;

public class DeleteAndEarnApproach1 {

    public int deleteAndEarn(int[] nums) {

        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        Map<Integer, Integer> cache = new HashMap<>();
        int maxValue = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], cache.getOrDefault(nums[i], 0) + nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
            minValue = Math.min(minValue, nums[i]);
        }

        int prev = cache.get(minValue);
        int curr = Math.max(prev, cache.getOrDefault(minValue + 1, 0));

        for (int i = minValue + 2; i <= maxValue; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + cache.getOrDefault(i, 0));
            prev = temp;
        }

        return curr;

    }
}