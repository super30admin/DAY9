# // Time Complexity : O(n) 
# // Space Complexity :O(n) for array
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Initialize an Array. Add count at index.
# We can't add alternating elements so use robber dp solution.


class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        size = max(nums)                                   
        arr = [0] * (size+1)                            # initialize array

        for num in nums:                                # count/freq map 
            arr[num] += num
        
        x1 = 0                                          # robber solution
        x2 = 0                                          
        for i in range(size+1):                          
            temp = max(x1+arr[i],x2)
            x1 =  x2
            x2 = temp
        return x2

#// Hashmap solution: O(nlog(n))
# class Solution:
#     def deleteAndEarn(self, nums: list[int]) -> int:
#         hMap = {}
#         size = max(nums)
        
#         for num in nums:                                # frequency map
#             if num in hMap:
#                 hMap[num] += num
#             else:
#                 hMap[num] = num
            
#         for i in range(size + 1):                       # fill freq map
#             if i not in hMap:
#                 hMap[i] = 0

#         x1 = 0                                          # robber solution
#         x2 = 0
#         for i in sorted(hMap):                          # sorted map => O(nLogn)
#             temp = max(x1+hMap[i],x2)
#             x1 =  x2
#             x2 = temp
#         return x2

print(Solution().deleteAndEarn([2,2,3,3,3,4,5,5,3,2,1,6]))