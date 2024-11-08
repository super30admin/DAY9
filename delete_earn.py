# The code defines a deleteAndEarn method to find the maximum points that can be earned by "deleting" numbers from a list.
# When a number 'n' is chosen, all occurrences of 'n' contribute to the score, but all occurrences of 'n-1' and 'n+1' are removed from further consideration.
# This problem is similar to the "House Robber" problem, where we can't select adjacent houses.

# Setup:
#   - If nums is empty, we return 0 since there's nothing to earn.
#   - A frequency array 'freq' is created where freq[i] represents the total points gained by selecting all occurrences of the number 'i' in nums.
#       - Each element in nums contributes its value to freq at its respective index.

# Dynamic Programming Array:
#   - A dp array is initialized to store the maximum points earned up to each number.
#   - dp[1] is set to freq[1] since that's the maximum points for just the number 1.
#   - For each number i starting from 2:
#       - dp[i] is the maximum of:
#           - Taking 'i' and adding it to dp[i-2] (the maximum points for non-adjacent selections).
#           - Skipping 'i' and taking dp[i-1] (maximum points up to the previous number).
#       - This ensures that we maximize points while respecting the delete-and-earn constraint.

# Final Result:
#   - dp[len(freq) - 1] holds the maximum points that can be earned by choosing numbers from nums under the rules, which is returned.

# TC: O(n + m) - where 'n' is the number of elements in nums (for creating freq) and 'm' is the range of numbers (for filling dp).
# SC: O(m) - The space complexity is linear with respect to the range of numbers due to the freq and dp arrays.


from typing import List


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