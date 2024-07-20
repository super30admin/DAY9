//Dynamic Programming   
                                                                              //Time = O(n)
                                                                              //space = O(m)
  
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # create a frequency map of the input nums
        freq_map = {}
        for num in nums:
            freq_map[num] = freq_map.get(num, 0) + 1
        
        # define the dynamic programming table
        dp = [0] * (max(freq_map.keys(), default=0) + 1)
        dp[1] = freq_map.get(1, 0)
        
        # compute the maximum points that can be earned using dynamic programming
        for num in range(2, len(dp)):
            points = num * freq_map.get(num, 0)
            dp[num] = max(dp[num-1], dp[num-2] + points)
        
        # return the maximum points that can be earned
        return dp[-1]
