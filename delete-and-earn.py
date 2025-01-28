# tc O(n log n), sc O(n).
counts = Counter(nums)
nums = sorted(counts.keys())
first, second = 0, counts[nums[0]] * nums[0]

for idx in range(1, len(nums)):
    
    if nums[idx-1] == nums[idx] - 1:
        third = max(second, counts[nums[idx]] * nums[idx] + first)
    else:
        third = counts[nums[idx]] * nums[idx] + second
    first, second = second, third

return second