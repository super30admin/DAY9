# // Time Complexity : O(n) 
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : initiallly how to convert this into house robber

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        result=0
        maxVal=max(nums)

        sumVal=[0] *(maxVal+1)
        for i in range(len(nums)):
            sumVal[nums[i]]+=nums[i]
        print(sumVal)


        dpMax=[0]*(maxVal+1)
        dpMax[0]=sumVal[0]
        dpMax[1]=sumVal[1]

        for i in range(2,len(sumVal)):
            dpMax[i]=max(dpMax[i-1],sumVal[i]+dpMax[i-2])
        

        return dpMax[-1]
        
# Approach:
# First converted the problem into house robber and then solved as the same way as house robber.