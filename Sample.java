// Time Complexity : O(n) as we need to iterate through nums array to get maximum and also to get the number of points.
// Space Complexity : O(n) as we need dp matrix to complete the computations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Having hard time solving DP problems but following the class solution.


// Your code here along with comments explaining your approach
// First we will iterate through all the elements in the array to get the maximum from the array. Then we will create an array which will have the sum of all the 
// same elements at it's index. For example, at index 2 of arr will have sum of all 2s in the original nums array. First we will assign prev pointer to first
// element and current pointer to the element which is maximum between prev and current. Then we will loop from second element to the last element of arr.
// Now in this loop what we will do is we will store the current pointer in the temporary variable and check the maximum between current pointer sum and the sum
// of prev and current + 1 sum. For example, we will check maximum between sum of 2s and sum of 3s and 4s. Then assign current pointer to that maximum and previous
// pointer to current. In this way our current pointer will always have the maximum sum. At the end we will just simply return the current pointer.
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;

        if (nums == null || nums.length == 0) {
            return 0;
        }

        for(int num: nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max+1];

        for(int num: nums) {
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for(int i = 2; i <= max; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }

        return curr;
    }
}


// Time Complexity : O(m*n) where m is length of matrix (number of columns) and n is height of matrix (number of rows)
// Space Complexity : O(m*n) as it is required to store DP matrix.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Solved this on my own with the reference from Paint House Problem.


// Your code here along with comments explaining your approach
// We can follow same logic as we followed for Paint House. We will follow the approach from bottom row to top row. In the second last row of metrix we will check
// the condition for current element. If the current element is middle we will check 3 elements (1 below and 2 diagonal) which one is smaller and we will add it 
// to current element and we will take care of edge cases (0th column and last column) separately. At the end of this computation the top row will have 
// possible sums and we will iterate through just top row and check the minimum sum and return it.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;

        int result[][] = new int[n][m];

        for (int j = 0; j < m; j++) {
            result[n-1][j] = matrix[n-1][j];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int nextRowmin = Integer.MAX_VALUE;

                if(j == 0) {
                    nextRowmin = Math.min(result[i+1][j], result[i+1][j+1]);
                } else if(j == m-1) {
                    nextRowmin = Math.min(result[i+1][j-1], result[i+1][j]);
                } else {
                    nextRowmin = Math.min(result[i+1][j-1], 
                    Math.min(result[i+1][j], result[i+1][j+1]));
                }

                result[i][j] = matrix[i][j] + nextRowmin;
            }
            
        }

        for (int i = 0; i < m; i++) {
            if(result[0][i] < min) {
                min = result[0][i];
            }
        }

        return min;

    }
}