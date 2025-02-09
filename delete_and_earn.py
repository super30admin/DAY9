# Time complexity - O(n)
# Space complexity - O(n) 

# Approach - Create a hashmap to maintain count of repetitive points and a set for all unique points. Iterate
# through the unique points, compute current Earn. If dp[curr-1] Earn cannot be added to curr Earn, then add
# dp[curr-2] Earn and compare it to dp[curr-1] to get max so far. IF dp[curr-1] Earn can be added, then simply
# add it. Return last value of dp.

from typing import List
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        new = []
        count = {}
        for n in sorted(nums):
            if n not in count:
                new.append(n)
                count[n] = 1
            else:
                count[n] += 1
        
        dp = [0 for i in range(len(new))]

        for i in range(len(new)):
            currEarn = new[i] * count[new[i]]
            # can't use prev
            if i >= 1 and (new[i] - new[i-1] == 1):
                if i == 1:
                    dp[i] = max(currEarn, dp[i-1])
                else:
                    dp[i] = max(currEarn + dp[i-2], dp[i-1])
            else:
                dp[i] = dp[i-1] + currEarn
        return dp[-1]