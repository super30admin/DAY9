'''
    Time Complexity: O(max(n, max(nums)))
    Space Complexity: O(max(nums))
    Ran successfully on leetcode
    Approach: "Dynamic Programming:
    Convert the problem into the House Robber problem by using scores for each number and solve it. 
    Optimize it by using a 2 variables instead of an array. 
    Optimize it further using a hashtable instead of an array and iterating over minimum to maximum of the input"
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maximum = -1
        minimum = pow(10,4) + 1 #More than the input range

        for i in range(len(nums)):
            if nums[i] < minimum:
                minimum = nums[i]
            if nums[i] > maximum:
                maximum = nums[i]
            
        scores = {}

        for i in range(len(nums)):
            if nums[i] not in scores:
                scores[nums[i]] = nums[i]
            else:
                scores[nums[i]] += nums[i]

        prev = scores[minimum]

        if minimum + 1 in scores:
            cur = max(prev, scores[minimum+1]) 
        else:
            cur = prev

        for i in range(minimum + 2, maximum+1):
            temp = cur
            
            if i in scores:
                cur = max(temp, scores[i] + prev)
            else:
                cur = max(temp, prev)
            prev = temp

        return cur