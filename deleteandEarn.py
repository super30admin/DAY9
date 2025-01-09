# Time Complexity : O(max(m,n))
# Space Complexity :O(m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# make a bucket array of length max(nums) fill it with max of prev and curr return the last curr element

def deleteAndEarn(self, nums: List[int]) -> int:


    if not nums:
        return 0

    bucket = [0] * (max(nums)+1)
    for num in nums:
        bucket[num] += num
    
    prev = 0
    curr = 0

    for i in range(len(bucket)):
        temp = curr 
        curr = max(curr,bucket[i]+ prev)
        prev = temp
    return curr
        


         
        