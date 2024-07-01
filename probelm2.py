class Solution:
    def helper(self,matrix,index,row,sumi):
        if row == len(matrix):
            return sumi
        
        if index==0:
            return min(self.helper(matrix,0,row+1,sumi+matrix[row][index]), self.helper(matrix,1,row+1,sumi+matrix[row][index+1]) )
        if index==1:
            return min(self.helper(matrix,index-1,row+1, sumi+matrix[row][1]), min(self.helper(matrix,index,row+1,sumi+matrix[row][1]), self.helper(matrix,index+1,row+1,sumi+matrix[row][1])))
        
        if index==2:
             return min(self.helper(matrix,index-1,row+1,sumi+matrix[row][2]), self.helper(matrix,index,row+1,sumi+matrix[row][2]))
        
        return 1234
    # time: O(n2)
    # space: O(n2)
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix)==0:
            return 0
        
        m = len(matrix)
        n = len(matrix[0])
        
        for row in reversed(range(m-1)):
            for col in range(n):
                
                if col==0:
                    matrix[row][col] = matrix[row][col] + min(matrix[row+1][0], matrix[row+1][1])
                elif col==n-1:
                    matrix[row][col] = matrix[row][col] + min(matrix[row+1][col-1], matrix[row+1][col])
                else:
                     matrix[row][col] = matrix[row][col] + min(matrix[row+1][col-1], min(matrix[row+1][col], matrix[row+1][col+1]))
                     
    
        return min(matrix[0])