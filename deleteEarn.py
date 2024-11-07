# // Time Complexity : O(nlogn)  due to sorting
# // Space Complexity :O(n) for hashmap
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Make a hashmap. Add 0 frequency items. Sort the hashmap. We cant add alternating elements so use robber dp solution.

class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        hMap = {}
        size = max(nums)
        
        for num in nums:                                # frequency map
            if num in hMap:
                hMap[num] += num
            else:
                hMap[num] = num
            
        for i in range(size + 1):                       # fill freq map
            if i not in hMap:
                hMap[i] = 0

        x1 = 0                                          # robber solution
        x2 = 0
        for i in sorted(hMap):                          # sorted map => O(nLogn)
            temp = max(x1+hMap[i],x2)
            x1 =  x2
            x2 = temp
        return x2

print(Solution().deleteAndEarn([2,2,3,3,3,4,5,5,3,2,1,6]))