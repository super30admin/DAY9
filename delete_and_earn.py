def delete_and_earn(nums):
    if not nums:
        return 0

    max_num = max(nums)
    points = [0] * (max_num + 1)

    # Aggregate points for each number
    for num in nums:
        points[num] += num

    # Use house-robber logic to maximize points
    prev, curr = 0, 0
    for point in points:
        prev, curr = curr, max(curr, prev + point)

    return curr

# Time Complexity: O(n + m), where n is the length of nums, and m is the maximum value in nums.
# Space Complexity: O(m), where m is the maximum value in nums (space used by the points array).
