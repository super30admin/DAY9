# // Time Complexity : O(3^n) 
# // Space Complexity : O() stack space.  
# // Did this code successfully run on Leetcode : no going TLE
# // Any problem you faced while coding this : not able to convert it into dp

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        m=len(matrix)
        n=len(matrix[0])

        def helper(row,col):
            if row>m  or col>=n or col<0 or row<0:
                return 9999999
            if row==m-1:
                return matrix[row][col]
            case1=matrix[row][col]+helper(row+1,col)
            case2=matrix[row][col]+helper(row+1,col+1)
            case3=matrix[row][col]+helper(row+1,col-1)
            return min(case1,case2,case3)
        
        res=9999999
        for i in range(len(matrix[0])):
            x=helper(0,i)
            res=min(x,res)

        return res
    
    # approach:

    # i tried it the same way as the paint house problem. i initially sketched the tree and from there i coded the recursive code.
