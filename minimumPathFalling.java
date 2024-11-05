// Time Complexity : O(n square ) to traverse through all the elements in the matrix
// Space Complexity : O (2n) we are creating two arrays of size n to store the intermediate minimum sums in each iteration
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, I missed the creation of the temp array while minimizing the space complexity by using one dimension arrray. 
class minimumPathFalling {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] tracker = new int[n];
        for(int i=0; i<n; i++){
            int[] temptracker = new int[n];
            for(int j=0; j<n; j++){
                if(i == 0){
                    temptracker[j] = matrix[i][j];
                }
                else if(j ==0){
                    temptracker[j] = matrix[i][j] + Math.min(tracker[j], tracker[j+1]);
                }
                else if(j == n-1){
                    temptracker[j] = matrix[i][j] + Math.min(tracker[j], tracker[j-1]);
                }
                else{
                    temptracker[j] = matrix[i][j] + Math.min(Math.min(tracker[j], tracker[j-1]), tracker[j+1]);
                }
            }
            tracker = temptracker;
            }
        int result = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            result = Math.min(result, tracker[i]);
        }
        return result;
    }
}