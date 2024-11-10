# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)
## Solution1:
## Time Complexity:O(n+max) Space Complexity:O(max)
## Here I have made a new array by finding out the maximum number of element in the array, using it I have stored the element in
## tbat specific index location so I use the previous as well as current to change based on max. We can also use hashmap over here .

class Solution {
    public int deleteAndEarn(int[] nums) {
       int max=Integer.MIN_VALUE;

       for(int num:nums)
       {
        max=Math.max(max,num);
       }

       int[] arr=new int[max+1];
       for(int num:nums){
        arr[num]+=num;
       }
       int curr=arr[1];
       int prev=arr[0];
       curr=Math.max(curr,prev);
       for(int i=2;i<arr.length;i++)
       {
         int temp=curr;
         curr=Math.max(curr,prev+arr[i]);
         prev=temp;

       }
       return curr;
    }
}


## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
## Solution2
## Time Complexity:O(m*n) Space Complexity:O(n)
## Here I have used a dp array that stores the values of initial row and on every iteration I update the dp values based on the new minimum
## found according to the search and in the end i return the most minimum sum found.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize dp array with the first row of the matrix
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
        }

        // Traverse from the second row to the last row
        for (int i = 1; i < m; i++) {
            // Temporary array to store current row calculations
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int upLeft = j > 0 ? dp[j - 1] : Integer.MAX_VALUE;
                int up = dp[j];
                int upRight = j < n - 1 ? dp[j + 1] : Integer.MAX_VALUE;

                // Update temp[j] with the minimum falling path sum to current cell
                temp[j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
            }
            // Copy the current row results into dp for the next iteration
            dp = temp;
        }

        // Find the minimum path sum in the last row
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i]);
        }

        return min;
    }
}

