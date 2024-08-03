#Appraoch : Reduced to house robber
# TC:O(m+n) m is max number and n is the number of elements ===length of nums
# SC:O(m)



class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # Check if the input list is empty
        if not nums:
            return 0
        
        # Create a frequency array to store the sum of points for each number
        # The length of freq will be max(nums) + 1 to accommodate all possible values in nums
        freq = [0] * (max(nums) + 1) #watch video again for this logic if not understood, explained clearly
        
        # Fill the frequency array where freq[i] is the total points earned by taking 'i'
        for n in nums:
            freq[n] += n  # Add the value of 'n' to freq[n]

        # Initialize the dynamic programming array
        dp = [0] * len(freq)
        dp[0] = freq[0]  # Base case: if we only have 0, we can earn freq[0]
        dp[1] = max(freq[0], freq[1])  # Max points if we can take either 0 or 1
        
        # Iterate through the frequency array to fill the dp array
        for i in range(2, len(freq)):
            # Choose the maximum between:
            # 1. Not taking the current value (dp[i-1])
            # 2. Taking the current value (freq[i] + dp[i-2]) - we add freq[i] and skip the adjacent number
            dp[i] = max(dp[i-1], freq[i] + dp[i-2])
        
        # The last element of dp will contain the maximum points we can earn
        return dp[len(freq) - 1]
