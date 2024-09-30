#Approach
#Similar to house rob problem
# Every time we will choose or not choose the element if we choose same index will be passed to next
#recursive call else pass the next index to next recursive call.


# complexities
#Time Complexity : 2^(m+n)
#Space Complexity : O(N)


from typing import List


class Solution:
    def preprocess(self,nums:List[int])->List[int]:
        max_num = max(nums)
        pre_nums = [0]*(max_num+1)
        for num in nums:
            pre_nums[num] += num
        return pre_nums

    def deleteAndEarn(self, nums: List[int]) -> int:
        nums = self.preprocess(nums)
        n= len(nums)+1
        if n==1:
            return nums[0]

        last_but_two = 0
        prev = nums[0]
        curr = 0
        for i in range(1,len(nums)):
            curr = max(prev,nums[i]+last_but_two)
            last_but_two,prev = prev,curr
        return curr
