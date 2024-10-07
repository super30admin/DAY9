class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        max_point = {}
        
        if len(nums) == 1:
            return nums[0]
        
        for i in nums:
            if i in max_point:
                max_point[i] += i
            else:
                max_point[i] = i
        
        
        max_length = max(max_point)
        points = []
        
        for i in range(max_length+1):
            if i in max_point:
                points.append(max_point[i])
            else:
                points.append(0)
        print(points)
        
        
        k = len(points)
        dp = [0] * k
        
        dp[0] = points[0]
        dp[1] = max(points[0],points[1])
        
        for i in range(2, k):
            dp[i] = max(points[i] + dp[i - 2], dp[i-1])
        
        return dp[k-1]
        
        
        