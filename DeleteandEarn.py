class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxno = max(nums)
        preprocess = [0]*(maxno+1)
        for i in range(len(nums)):
            preprocess[nums[i]] += nums[i]
        skip = 0
        take = 0
        for i in range(1,len(preprocess)):
            tempSkip = skip
            skip = max(skip,take)
            take = tempSkip + preprocess[i]
        return max(skip,take)


        