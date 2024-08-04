## bottom up approach
## get the max number in the nums list. maintain a list of sets, which stores the coin and its count
## iterate over our nums list, use dp to check how to maximize our earnings

## Time Complexity O(n)
## Space COmplexity O(n)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        countDict = [0] * (max(nums) + 1)

        for i in nums:
            countDict[i] += i

        dp = [0] * (max(nums) + 1)
        dp[0] = 0
        dp[1] = countDict[1]

        for j in range(2, max(nums) + 1):
            dp[j] = max(dp[j-1], dp[j-2] + countDict[j])

        return dp[-1]
