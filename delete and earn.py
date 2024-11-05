# TC: O(max(n))
# SC: O(max(n))
# This code compiled on LC successfully

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        dic = {}
        for i in nums:
            if i not in dic.keys():
                dic[i] = i
            else:
                dic[i] += i
        
        maxElem = max(nums)
        lst = []
        for i in range(0, maxElem+1):
            if i not in dic.keys():
                lst.append(0)
            else:
                lst.append(dic[i])
        dp = lst
        for i in range(2, len(dp)):
            dp[i] = max(dp[i-1], dp[i] + dp[i-2])
        return dp[-1]
