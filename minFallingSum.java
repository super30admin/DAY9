class Solution {
    public int minFallingPathSum(int[][] matrix) {
       
       int n= matrix.length;
        int m=matrix[0].length;
        int min=999999;
        int t=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){

              t=Integer.MAX_VALUE;

              t= Math.min(t,matrix[i-1][j]);

              if(j-1>=0)
               t=Math.min(t,matrix[i-1][j-1]);

               if(j+1<n) 
               t=Math.min(t,matrix[i-1][j+1]);

               matrix[i][j]=matrix[i][j]+t;
            }
        }
           int v=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
           v=Math.min(v,matrix[n-1][i]);
        }
         
        return v;
    }
}