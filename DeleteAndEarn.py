def points1(nums, x, points):
    if not nums:
        return nums, points
    
    points = points + nums[x]
    i = 0
    nums1 = nums.copy()
    for i in range(len(nums)):
        if nums[i] == nums[x] or nums[i] == nums[x]-1 or nums[i] == nums[x]+1:
            nums1.remove(nums[i])
    return nums1, points


def deleteAndEarn(nums) -> int:
    maxpoints = 0
    for i in range(len(nums)):
        nums1 = nums.copy()
        points = 0
        
        while nums1:
            i = i%len(nums1)
            nums1, points = points1(nums1, i, points)
            
        maxpoints = max(points, maxpoints)
            
    return maxpoints


nums = [2,2,3,3,3,4]

print(deleteAndEarn(nums))

    