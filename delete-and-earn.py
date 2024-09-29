"""
The idea is to first try the greedy approach, but the greedy won't work here, for example [2,2,2,2,3,1,1,1] the greedy
gives max profit of 3, but actually it is 8, another way is to choose an element with max frequency.
that would fail in the case: [2,2,2,2,10,10,10,1,1,1].
Then we try an exhaustive approach, where we try and get all the possible solutions using the recursive tree.
The idea here is to first pre-process the given array, like store the max profit with the given points into an array,
with index being that point and value at index being the max profit by that point. Now the idea becomes in this array
2 adjacent points cannot be chosen. Hash map can be chosen here since it is not ordered. However,
what if there are to many zero in the array? then in this case hash map can be chosen to save on space. But does it
really save space?. Under the hood, hash map also uses array so it would depend on the hashing technique used.
Time complexity of such an approach is 2^n and space is O(n).
Since in the recursive approach, repeated problems have founded, those could be saved in some DS
for further optimization.
Since there is one parameter 1 D array could be used.
Time complexity of such an approach is O(n) + O(max(nums)) and space is n + O(max(nums)).
Todo: solve with one variable not 1D array
"""
from typing import List


def dp_sol(self, nums):
    cols = len(nums) + 1
    dp = [0 for _ in range(cols)]
    dp[0] = 0
    dp[1] = nums[0]
    for i in range(1, cols):
        dp[i] = max(dp[i - 1], nums[i - 1] + dp[i - 2])

    return dp[cols - 1]


def deleteAndEarn(self, nums: List[int]) -> int:
    profit_nums_size = max(nums) + 1
    profit_nums = [0 for _ in range(profit_nums_size)]

    for idx, val in enumerate(nums):
        profit_nums[val] += val

    print(profit_nums)
    return self.dp_sol(profit_nums)