def deleteAndEarn(nums) -> int:
    max1 = 0
    for i in nums:
        if i > max1:
            max1 = i
    arr = [0] * (max1+1)
    for i in range(len(nums)):
        arr[nums[i]] += 1

    for i in range(len(arr)):
        arr[i] = arr[i] * i

    if len(nums) >= 2:
        for i in range(2,len(arr)):
            arr[i] = max(arr[i-1], arr[i-2]+arr[i])
        
    return max(arr[-2],arr[-1])

nums = [3,4,2]

print(deleteAndEarn(nums))
