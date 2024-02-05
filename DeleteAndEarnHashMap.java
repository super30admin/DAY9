// TC - O(max(N, maxKey))
// SC - O(N)

// Constraints:
// 1 <= nums.length <= 2 * 10^4
// 1 <= nums[i] <= 10^4

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarnHashMap {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            Map<Integer, Integer> numToFreqMap = new HashMap<>(); //Array under the hood
            int minKey = Integer.MAX_VALUE;
            int maxKey = Integer.MIN_VALUE;

            // [2,1,8,1,2,4,4,6,4,7,3,3]
            // [0,1,2,3,4,6,7,8]
            // [0,2,4,6,12,6,7,8] House Robber MAP
            // Missing 5 => Has to be compensated in House Robber Algorithm
            // For 6, max(value5, 6+value4) as per House Robber Algorithm
            for (int num : nums) { // O(N)
                numToFreqMap.put(num, numToFreqMap.getOrDefault(num, 0) + num);
                minKey = Math.min(minKey, num);
                maxKey = Math.max(maxKey, num);
            }

            int prevToAdjacentHouse = numToFreqMap.get(minKey);
            int adjacentHouse = Math.max(numToFreqMap.get(minKey), numToFreqMap.getOrDefault(minKey + 1, 0));
            // [2 1 0 3 5 4]
            // [2 2 2 5 7 9]
            // 9 = max(7, 4+5)
            for (int i = minKey + 2; i <= maxKey; i++) { // O(maxKey)
                int temp = adjacentHouse;
                adjacentHouse = Math.max(adjacentHouse, prevToAdjacentHouse + numToFreqMap.getOrDefault(i, 0));
                prevToAdjacentHouse = temp;
            }

            return adjacentHouse;
        }
    }
}