# time: O(n+k)
# space: O(n+k)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0

        count = collections.Counter(nums)
        nums = sorted(list(set(nums)))
        earn1, earn2 = 0,0

        for i in range(len(nums)):
            cur = count[nums[i]]*nums[i]

            if i>0 and nums[i] == nums[i-1] + 1:
                temp = earn2
                earn2 = max(cur + earn1, temp)
                earn1 = temp
            else:
                temp = earn2
                earn2 = cur+earn2
                earn1 = temp
        
        return earn2



            