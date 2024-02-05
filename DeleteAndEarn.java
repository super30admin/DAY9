// TC - O(max(N, maxValue))
// SC - O(maxValue)

// Constraints:
// 1 <= nums.length <= 2 * 10^4
// 1 <= nums[i] <= 10^4

public class DeleteAndEarn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int maxValue = Integer.MIN_VALUE;
            for (int num : nums) {                              // O(N)
                maxValue = Math.max(maxValue, num);
            }

            // [2,1,8,1,2,4,4,6,4,7,3,3] maxValue = 8
            // [0,1,2,3,4,5,6,7,8]
            // [0,2,4,6,12,0,6,7,8] House Robber array
            int[] houseRobberArray = new int[maxValue + 1];
            for (int num : nums) {                              // O(maxValue)
                houseRobberArray[num] += num;
            }

            int prevToAdjacentHouse = houseRobberArray[0];
            int adjacentHouse = Math.max(houseRobberArray[0], houseRobberArray[1]);
            // [2 1 0 3 5 4]
            // [2 2 2 5 7 9]
            // 9 = max(7, 4+5)
            for (int i = 2; i < houseRobberArray.length; i++) { // O(maxValue)
                int temp = adjacentHouse;
                adjacentHouse = Math.max(adjacentHouse, prevToAdjacentHouse + houseRobberArray[i]);
                prevToAdjacentHouse = temp;
            }

            return adjacentHouse;
        }
    }
}