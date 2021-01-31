class minimumfallingpath {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }

        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){//first elements
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }
                else if(j==m-1){//last elements
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }
                else{//middle elements
                    matrix[i][j]+=Math.min(matrix[i-1][j-1],(Math.min(matrix[i-1][j],matrix[i-1][j+1])));
                }
            }
        }

        //This is for optimal answer
        int min=Integer.MAX_VALUE;
        for(int x:matrix[n-1]){
            if(x<min){
                min=x;
            }
        }
        return min;
    }
}


//time complexiy will be=O(n)