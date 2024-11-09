"Time Ccomplexity is O(m*n)"
"Space Complexity is O(N)"


from collections import Counter

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        # Count the occurrence of each number
        count = Counter(nums)
        max_num = max(nums)
        
        # Create points array where points[i] = i * count[i]
        points = [0] * (max_num + 1)
        for num in count:
            points[num] = num * count[num]
        
        # Dynamic programming to maximize points
        dp = [0] * (max_num + 1)
        dp[1] = points[1]
        
        for i in range(2, max_num + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + points[i])
        
        return dp[max_num]
