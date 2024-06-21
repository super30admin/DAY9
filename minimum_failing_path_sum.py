"""
DP-3

Problem1: (https://leetcode.com/problems/delete-and-earn/)

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either
directly below or diagonally left/right. Specifically, the next element from position (row, col) will 
be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Example1:
Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13

Example2:
Input: matrix = [[-19,57],[-40,-5]]
Output: -59

Time Complexity : O(n^2)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
This is similar to Paint House. 
Trick is to start iterating from last 2nd row and keep on check there previous houses and see which one is minimum and adding 
the current value and moving to top. Finally when you complete the iteration the min of the 0th row will have the
result.
"""

# Approach 1 modifying existing matrix
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix or len(matrix) == 0:
            return 0

        n = len(matrix)

        for i in range(n-2, -1, -1): # start from 2nd last row
            for j in range(0, n):
                if j == 0: # left corner
                    matrix[i][j] =  matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1: # right corner
                    matrix[i][j] =  matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1])
                else: # inbetween
                    matrix[i][j] =  matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])

        return min(matrix[0])
    

# Approach 2 using 1d dp array space of O(n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix or len(matrix) == 0:
            return 0

        n = len(matrix)

        dp = []
        for i in range(n):
            dp.append(matrix[n-1][i])

        for i in range(n-2, -1, -1):
            curr = []
            for j in range(0, n):
                if j == 0: # left
                    curr.append(matrix[i][j] + min(dp[j], dp[j+1]))
                elif j == n-1:
                    curr.append(matrix[i][j] + min(dp[j], dp[j-1]))
                else:
                    curr.append(matrix[i][j] + min(dp[j-1], dp[j], dp[j+1]))
            dp = curr

        return min(dp)


        
        
        