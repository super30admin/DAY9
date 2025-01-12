#Time complexity: O(n)
#Space complexity: O(n)
#Leetcode: Yes

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        max_val = 0
        dp_hash = {}
        
        for i in range(len(nums)):
            max_val = max(max_val,nums[i])
            if nums[i] in dp_hash:
                dp_hash[nums[i]] += nums[i]
            else:
                dp_hash[nums[i]] = nums[i]
        
        skip = 0
        take = 0

        for i in range(1,max_val+1):
            tempSkip = skip
            skip = max(skip, take)
            take = tempSkip + dp_hash.get(i,0)
        
        return max(skip, take)

