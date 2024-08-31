# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)


class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        for(int num:nums){
            maxi=Math.max(maxi,num);
        }
        int[] temp=new int[maxi+1];
        for(int num:nums){
            temp[num]+=num;
        }
        // int dp[]=new int[temp.length+1];
        int prev=temp[0];
        int curr=Math.max(temp[0],temp[1]);
        for(int i=2;i<=maxi;i++){
            int tempVar=curr;
            curr=Math.max(curr,prev+temp[i]);
            prev=tempVar;
        }
        return curr;
    }
}

T.C=O(n)
S.C=O(1)


## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int ld=0,rd=0,d=0;
        for(int i=n-2;i>=0;i--)
            for(int j=0;j<m;j++)
            {
                if(j>0)
                    ld=matrix[i+1][j-1];
                else if(j<=0)
                    ld=Integer.MAX_VALUE;
                d=matrix[i+1][j];
                if(j<m-1)
                    rd=matrix[i+1][j+1];
                else if(j>m)
                    rd=Integer.MAX_VALUE;
                
                matrix[i][j]+=Math.min(ld,Math.min(rd,d));
            }
        //System.out.print(matrix[1][0]);
        int mini=Integer.MAX_VALUE;
        for(int j=0;j<m;j++)
            mini=Math.min(mini,matrix[0][j]);
        return mini;
    }
}

T.C=O(n^2)
S.C=O(1)