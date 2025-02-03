//MEMOIZATION
/* Time Complexity: O(n) - where n is the maximum element in the array.
 * Space Complexity: atmost we solve n subproblems so the space to store is O(n).
 * Leetcode: yes
 * Any Problems: no
 */

 //TABULATION
/* Time Complexity: O(n) - where n is the maximum element in the array.
 * Space Complexity: atmost we solve n subproblems so the space to store is O(n). can be optimized to O(1) as we are just using previous two indices.
 * Leetcode: yes
 * Any Problems: no
 */

import java.util.HashMap;
import java.util.Arrays;
public class DeleteEarn
{
    //MEMOIZATION
    private int helper(int num, HashMap<Integer, Integer> map, int[] dp)
    {
        if(num <= 0)
            return 0;
        if(dp[num] != -1)
            return dp[num];
        dp[num] = Math.max(helper(num-1, map, dp), map.getOrDefault(num, 0) * num + helper(num-2, map, dp));
        return dp[num];
    }
    public int deleteAndEarnMemoization(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_elem = 0;
        for(int i=0; i<nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            max_elem = Math.max(max_elem, nums[i]);
        }
        int[] dp = new int[max_elem+1];
        Arrays.fill(dp, -1);


        return helper(max_elem, map, dp);
    }

    //TABULATION
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_elem = 0;
        for(int i=0; i<nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            max_elem = Math.max(max_elem, nums[i]);
        }
        int[] dp = new int[max_elem+1];
        dp[0] = 0;
        dp[1] = map.getOrDefault(1, 0);

        for(int i=2; i<=max_elem; i++)
            dp[i] = Math.max(dp[i-1], map.getOrDefault(i, 0)*i + dp[i-2]);
        return dp[max_elem];
    }
}