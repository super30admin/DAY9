# Problem 24: (https://leetcode.com/problems/delete-and-earn/)

#Time Complexity : O( max(maxn,n))
# Space Complexity : O(maxn)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = len(nums)
        if nums == 0 or len(nums) == 0:
            return 0
        #n = len(nums)
        maxn =  - sys.maxsize - 1
        #maxn = float('inf')

        for i in range(n): # getting the max value out of nums
            maxn = max(maxn,nums[i])
        
        ar = [0] * (maxn+1)
        for i in range(n):
            curr = nums[i] #taking a frequency array
            ar[curr] += curr
        
        prev = ar[0]
        curr = max(prev,ar[1])
        for i in range(2,len(ar)):
            temp = curr 
            curr = max(curr, prev+ar[i]) # getting which way we can maximize the sum,
            prev = temp #by taking the cur or my taking prev + ar[i]
        return curr 


