# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if  not nums:
            return 0

        freq = [0] * (max(nums)+1)
        for n in nums:
            freq[n] += n

        dp = [0] * len(freq)
        dp[1] = freq[1]
        for i in range(2, len(freq)):
            dp[i] = max(freq[i] + dp[i-2], dp[i-1])

        return dp[len(freq)-1]


## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        m, n = len(A), len(A[0])

        if m == 1 or n == 1:
            return A[0][0]

        dp = [[float('inf')] * n for _ in range(m)]
        ans = float('inf')

        for i in range(len(A)):
            ans = min(ans, self.minFallingPathSumHelper(A, 0, i, dp))

        return ans

    def minFallingPathSumHelper(self, A, row, col, dp):
        m, n = len(A), len(A[0])

        if dp[row][col] != float('inf'):
            return dp[row][col]

        if row == m - 1:
            return A[row][col]

        left = right = float('inf')

        if col > 0:
            left = self.minFallingPathSumHelper(A, row + 1, col - 1, dp)

        straight = self.minFallingPathSumHelper(A, row + 1, col, dp)

        if col < n - 1:
            right = self.minFallingPathSumHelper(A, row + 1, col + 1, dp)

        dp[row][col] = min(left, min(straight, right)) + A[row][col]

        return dp[row][col]


