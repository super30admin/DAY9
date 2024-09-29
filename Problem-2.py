'''
    Time Complexity: O(n^2)
    Space Complexity: O(n)
    Ran successfully on leetcode
    Approach: Similar to Paint house problem but handle multiple columns cases instead of just 3.
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)

        # dp = [[0 for j in range(n)] for i in range(n)]

        dp = matrix[n-1]

        for i in range(n-2, -1, -1):
            temp = dp[:]
            for j in range(0, n):
                cur = matrix[i][j]

                case0 = cur + temp[j-1] if j-1 >= 0 else sys.maxsize
                case1 = cur + temp[j]
                case2 = cur + temp[j+1] if j+1 < n else sys.maxsize

                dp[j] = min(case0, min(case1, case2))

        return min(dp)