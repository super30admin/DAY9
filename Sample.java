
// Problem1: (https://leetcode.com/problems/delete-and-earn/)
// Time Complexity : O(n) where n is the length of the input array
// Space Complexity : O(n) where n is the length of the input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : It uses a HashMap to store the sum of elements that have the same value. It then iterates through the values from the minimum value to the maximum value in the array, calculating the maximum sum that can be obtained up to that value by either including the current value or excluding it. Finally, it returns the maximum sum.

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + nums[i]);
        }
        System.out.println(map);
        int prev = map.get(min);
        int curr = prev;
        if (map.containsKey(min + 1)) {
            curr = Math.max(prev, map.get(min + 1));
        }
        for (int i = min + 2; i <= max; i++) {
            int temp = curr;
            if (map.containsKey(i)) {
                curr = Math.max(curr, map.get(i) + prev);
            } else {
                curr = Math.max(curr, prev);
            }
            prev = temp;
        }
        return curr;
    }
}

// Problem2: https://leetcode.com/problems/minimum-falling-path-sum/
// Time Complexity : O(n^2) where n is the length of the input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: It iterates through the matrix from the second row, calculating the minimum sum that can be obtained at each cell by adding the current value to the minimum of the three possible values from the previous row. Finally, it returns the minimum value from the last row.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, matrix[n - 1][i]);
        }
        return min;

    }
}