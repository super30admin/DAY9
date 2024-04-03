// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode: (https://leetcode.com/problems/delete-and-earn/)

// ALgo:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Greedy:
 * [3, ,3, 6, 7, 8, 4, 4, 3]
 * 
 * Pick Max: 8 + 6 + 4 * 2 = 22 --> not the best possible answer
 * 
 * hence, greedy fails
 * 
 * go exhaustive
 * 
 * algo: pick not pick
 * pick -> then don't pick adjacent
 * 
 * boils down to house robber
 * 
 * but here pick what?
 * ans: pick the num
 * 
 * basically store num, freq in a map
 * 
 * Sort the keys
 * 
 * apply house robber pattern to the sorted keys
 * 
 * Sort the array
 */
public class DeleteAndEarn_LC_740 {
    /**
     * TC: O(2 ^ k)
     * SC: O(4k)
     * 
     * @param nums
     * @return
     */
    public int deleteAndEarn_recursion(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        Integer[] keys = freqMap.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);

        int n = keys.length;

        return max_recursion(keys, n - 1, freqMap);
    }

    private int max_recursion(Integer[] nums, int index, Map<Integer, Integer> freqMap) {
        // base
        if (index < 0) {
            return 0;
        }
        int num = nums[index];
        int value = freqMap.get(num) * num;
        if (index == 0) {
            return value;
        }
        // logic
        int pick = value;
        if (nums[index - 1] == num - 1) {
            pick += max_recursion(nums, index - 2, freqMap);
        } else {
            pick += max_recursion(nums, index - 1, freqMap);
        }
        int notPick = max_recursion(nums, index - 1, freqMap);

        return Math.max(pick, notPick);
    }

    /**
     * TC: O( k)
     * SC: O(4k)
     * 
     * @param nums
     * @return
     */
    public int deleteAndEarn_memoize(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        Integer[] keys = freqMap.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);

        int n = keys.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return max_memoize(keys, n - 1, freqMap, dp);
    }

    private int max_memoize(Integer[] nums, int index, Map<Integer, Integer> freqMap, int[] dp) {
        // base
        if (index < 0) {
            return 0;
        }
        int num = nums[index];
        int value = freqMap.get(num) * num;
        if (index == 0) {
            return value;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        // logic
        int pick = value;
        if (nums[index - 1] == num - 1) {
            pick += max_memoize(nums, index - 2, freqMap, dp);
        } else {
            pick += max_memoize(nums, index - 1, freqMap, dp);
        }
        int notPick = max_memoize(nums, index - 1, freqMap, dp);

        return dp[index] = Math.max(pick, notPick);
    }

    /**
     * TC: O( k)
     * SC: O(3k)
     * 
     * @param nums
     * @return
     */
    public int deleteAndEarn_tabulation(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        Integer[] keys = freqMap.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);

        int n = keys.length;

        int num = keys[0];
        int value = freqMap.get(num) * num;
        int[] dp = new int[n];
        dp[0] = value;

        if (n == 1) {
            return dp[0];
        }
        int pick;
        num = keys[1];
        value = freqMap.get(num) * num;
        pick = value;
        if (keys[0] != num - 1) {
            pick += dp[0];
            dp[1] = pick;
        } else {
            dp[1] = Math.max(dp[0], value);
        }

        for (int index = 2; index < n; index++) {
            num = keys[index];
            value = freqMap.get(num) * num;
            pick = value;
            if (keys[index - 1] == num - 1) {
                pick += dp[index - 2];
            } else {
                pick += dp[index - 1];
            }
            int notPick = dp[index - 1];

            dp[index] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

    /**
     * TC: O( k)
     * SC: O(2k)
     * 
     * @param nums
     * @return
     */
    public int deleteAndEarn_spaceOptimization(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        Integer[] keys = freqMap.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);

        int n = keys.length;

        int num = keys[0];
        int value = freqMap.get(num) * num;
        int prev2 = value;

        if (n == 1) {
            return prev2;
        }
        int pick, prev;
        num = keys[1];
        value = freqMap.get(num) * num;
        pick = value;
        if (keys[0] != num - 1) {
            pick += prev2;
            prev = pick;
        } else {
            prev = Math.max(prev2, value);
        }

        for (int index = 2; index < n; index++) {
            num = keys[index];
            value = freqMap.get(num) * num;
            pick = value;
            if (keys[index - 1] == num - 1) {
                pick += prev2;
            } else {
                pick += prev;
            }
            int notPick = prev;

            prev2 = prev;
            prev = Math.max(pick, notPick);
        }

        return prev;
    }

    /**
     * Find the path via backtracking
     * 
     * @param nums
     * @return
     */
    public int deleteAndEarn_findPath(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        Integer[] keys = freqMap.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);

        int n = keys.length;
        boolean[] paths = new boolean[n];

        int num = keys[0];
        int value = freqMap.get(num) * num;
        int prev2 = value;
        paths[0] = true;

        if (n == 1) {
            return prev2;
        }
        int pick, prev;
        num = keys[1];
        value = freqMap.get(num) * num;
        pick = value;
        if (keys[0] != num - 1) {
            pick += prev2;
            prev = pick;
            paths[1] = true;
        } else {
            prev = Math.max(prev2, value);
            if (prev2 < value) {
                paths[1] = true;
            }
        }

        for (int index = 2; index < n; index++) {
            num = keys[index];
            value = freqMap.get(num) * num;
            pick = value;
            if (keys[index - 1] == num - 1) {
                pick += prev2;
            } else {
                pick += prev;
            }
            int notPick = prev;

            prev2 = prev;
            prev = Math.max(pick, notPick);
            if (pick > notPick) {
                paths[index] = true;
            }
        }

        List<Integer> numsCollected = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            num = keys[i];
            if (paths[i]) {
                numsCollected.add(num);
                if (i > 0 && keys[i - 1] == num - 1) {
                    i--;
                }
            }
        }

        return prev;
    }

}