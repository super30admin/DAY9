# Time Complexity : O(n + k)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Delete and Earn

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxEarn = max(nums)
        arr = [0] * (maxEarn + 1) 

        for num in nums:
            arr[num] += num

        prev = arr[0]
        curr = max(arr[0],arr[1])

        for i in range(2, len(arr)):
            temp = curr
            curr = max(curr, arr[i]+prev)
            prev = temp

        return curr