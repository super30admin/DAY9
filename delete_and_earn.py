# Time complexity - O(max(m,n))
# Space complexity - O(m)
# tested on leetcode
# Transform the input into sums of freq for each number
# 
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        arr = [0] * (max(nums)+1) # O(m)
        for each in nums:
            arr[each] += each   
        prev = arr[0]
        curr = max(arr[0], arr[1])
        for i in range(2, len(arr)): # O(n)
            temp = curr 
            curr = max(curr, arr[i]+prev)
            prev = temp
        return curr
        
