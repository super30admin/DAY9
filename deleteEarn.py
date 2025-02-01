"""
740. Delete and Earn

DP Approach --
1. Get maxVal from nums
2. create dp for len(maxVal+1)
3. fill dp array
4. Now, choose/not choose by using a temp variable to store value of skip before it gets overwritten in next step
5. return max(skip, take)

TC -
O(n) --> to find maxVal
O(n) --> to create DP array
O(m) --> loop through DP array of len(maxVal + 1)
Final TC - O(n + m)

SC - O(m) where m = len(dp)
"""
import math

num = [2, 2, 3, 3, 3, 4]


def deleteAndEarn(nums):
    if nums is None or len(nums) == 0: return 0

    n = len(nums)

    maxVal = -math.inf
    for i in range(n):
        maxVal = max(maxVal, nums[i])

    dp = [0] * (maxVal + 1)

    for i in range(n):
        idx = nums[i]
        dp[idx] = dp[idx] + nums[i]

    # choose/not choose
    skip = 0
    take = dp[0]

    # update values of skip take
    for i in range(len(dp)):
        temp = skip
        skip = max(skip, take)
        take = temp + dp[i]

    return max(skip, take)


if __name__ == '__main__':
    print(deleteAndEarn(num))
