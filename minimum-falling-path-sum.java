// Time Complexity :O(m*n) 
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: i have tried greedy approach but it's failing in some cases so for exhaustive solution i am unable to do choose and not choose scenrio with given data because i need to hide nums[i]+1 and nums[i]-1 in the case 
// i have used anthoer array which is the length of maximun elemnt in nums array then it seems like house robber problem it self so ihave used memization approach by taking 1d array of size max of nums array 

class Solution {
    public int minFallingPathSum(int[][] matrix) {
                int r=matrix.length;
                int c=matrix[0].length;
                if(r == 0 || matrix == null){
                    return 0;
                }
                int[][] dp=new int[r][c];
                for(int i=0;i<c;i++){
                    dp[r-1][i] = matrix[r-1][i];
                }
               
              
                for(int i=r-2;i>=0;i--){
               for(int j=0;j<c;j++){
                if(j==0){
                 dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
                }else if(j == c-1){
                 dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j],dp[i+1][j-1]);
                }else{
                    System.out.println("index"+i+" "+j+""+c);
                  int min=  
                dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j],Math.min(dp[i+1][j-1],dp[i+1][j+1]));
                }
               }
                }
            
                int min=Integer.MAX_VALUE;
                for(int i=0;i<c;i++){
                min= Math.min(dp[0][i],min);
                }
                return min;
    }
}