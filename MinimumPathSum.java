// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * Create a 1d dp of n elements. For every row, we store the minimum sum at every index of the row in dp. Initially we store bottom row in dp.
 * Then we iterate row =n-2 to 0. For every row we calculate minimum at index and store it at that index in dp. This way we overwrite dp. 't' and 'v' 
 * are used to store the previous values of i-1th index in dp. Finally return the minimum value in dp. 
 */
public class MinimumPathSum {

    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
		int min=Integer.MAX_VALUE;
		
		int[] dp=new int[n];
		for(int i=0;i<n;i++) {
			dp[i]=arr[n-1][i];
		}
		for(int row=n-2;row>=0;row--) {
            int t=0;
            int v=0;
			for(int col=0;col<n;col++) {
				if(col==0) {
                    t=dp[col];
					dp[col]=arr[row][col]+Math.min(dp[col],dp[col+1]);
				}else if(col==n-1) {
					dp[col]=arr[row][col]+Math.min(dp[col],t);
				}else {
                    v=dp[col];
					dp[col]=arr[row][col]+Math.min(t,Math.min(dp[col],dp[col+1]));
                    t=v;
				}
			}
            
		}
		for(int j=0;j<n;j++) {
			min=Math.min(min, dp[j]);
		}
		return min;
    }
}