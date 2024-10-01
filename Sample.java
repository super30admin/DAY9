// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Delete and Earn
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_val = max(nums)
        freq = [0] * (max_val+1)

        for num in nums:
            freq[num] += num
        
        dp = [0] * len(freq)
        dp[0] = 0
        dp[1] = max(dp[0],freq[1])

        for i in range(2,len(freq)): //O(N)
            dp[i] = max(dp[i-1],freq[i]+dp[i-2])
        print(dp)
        return dp[-1]
//Minimum-path-sum
// I need to complete the DP solution. Once it's done, I will update the file and create a new pull request.