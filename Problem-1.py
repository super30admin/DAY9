# T.C = O(n+m) S.C = O(n)
# Stored every value sum corresponding to its index and than taking max in every operation
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_value = max(nums)

        arr = [0] * (max_value +1)

        for num in nums:
            arr[num] += num
        
        n = len(arr)

        if(n == 1):
            return arr[0]

        
        if(n == 2):
            return max(arr[0],arr[1])

        dp = [0] * n
        dp[0] = arr[0]
        dp[1] = max(arr[0],arr[1])

        for i in range(2,n):
            arr[i] = max(arr[i-1],arr[i-2]+arr[i])

        return arr[-1]