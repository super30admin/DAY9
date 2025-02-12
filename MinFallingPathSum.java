public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;

        int n=matrix.length;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if (j == 0) {
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }else if(j == n-1){
                    matrix[i][j]= matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }else{
                    matrix[i][j]= matrix[i][j]+Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<n;j++) {
            min=Math.min(min,matrix[0][j]);
        }
        return min;
    }

    }



/*
public int minFallingPathSum(int[][] matrix) {
    int min = Integer.MAX_VALUE;
    for(int i =0; i< matrix[0].length; i++){
        min = Math.min(helper(matrix, 0, i), min);
    }
    return min;
}

private int helper(int[][] matrix, int r, int c){
    //base
    if(r < 0 || r >= matrix.length || c <0 || c >= matrix[0].length) return Integer.MAX_VALUE;
    if(r == matrix.length - 1 && (c >=0 || c < matrix[0].length)) return matrix[r][c];
    //logic
    //case1
    int case1 = helper(matrix, r+1, c-1);
   //case2
    int case2 = helper(matrix, r+1, c+1);;
    //case3
    int case3 = helper(matrix, r+1, c);
    return matrix[r][c] + Math.min(case1, Math.min(case2,case3));

}*/
