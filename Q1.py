############# Delete and Earn

# Time Complexity : O(max(len of arr, max element))
# Space Complexity : O(max element)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# calculate the profit in a counting sort manner. Using the counting sort array calculate the cost if the element is taken or not.
def delete_and_earn(nums):
    if not nums:
        return 0
    
    count = [0] * (max(nums)+1)
    for num in nums:
        count[num] += num
    
    dp = [[0, 0] for _ in range(max(nums) + 1)]
    dp [0][0] = 0
    dp [0][1] = count[0]
    for i in range(1,len(dp)):
        dp[i][0] = max(dp[i-1][0],dp[i-1][1])
        dp[i][1] =  count[i] + dp[i-1][0]     
    
    return max(dp[-1])


# Time Complexity : O(max(len of arr, max element))
# Space Complexity : O(max element)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Optimise space for computation using two variables

def delete_and_earn(nums):
    if not nums:
        return 0
    
    count = [0] * (max(nums)+1)
    for num in nums:
        count[num] += num
    
    skip = 0
    take = count[0]
    for i in range(1,len(count)):
        temp = skip
        skip = max(skip,take)
        take =  count[i] + temp  
    
    return max(skip,take)
