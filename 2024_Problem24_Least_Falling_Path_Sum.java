//931. Minimum Falling Path Sum - https://leetcode.com/problems/minimum-falling-path-sum/description/
//Time Complexity: O(m*n)

class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){

                int minFromUp = 0;
                if(j==0)
                    minFromUp = Math.min(A[i-1][j],A[i-1][j+1]);
                else if(j==(n-1))
                    minFromUp = Math.min(A[i-1][j], A[i-1][j-1]);
                else
                    minFromUp = Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));

                A[i][j] += minFromUp;
            }
        }

        int min = A[n-1][0];
        for (int i = 1; i < n; i++)
            min = Math.min(min, A[n-1][i]);
        return min;
    }
}