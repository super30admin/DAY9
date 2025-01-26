
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        freq = Counter(nums)
        nums = list(sorted(set(nums))) # unique nums only points can be calculated using freq
        print(nums, freq)
        size = len(nums)-1 # giving last place to see points earned at every place
        memo = {}
        def dp(i):
            if i < 0: # empty array
                return 0
            if i in memo:
                return memo[i]
            earned_points = nums[i] * freq[nums[i]]
            # lets decide 
            # in both take these points or not
            # if we use it and if previous num + 1 = curr, we need to jump 2 places 
            if i > 0 and nums[i-1] == nums[i]-1:
                result = max(earned_points + dp(i-2), dp(i-1))
            else:
                result = max(earned_points + dp(i-1), dp(i-1))
            memo[i] = result
            return result
        return dp(size)
# time and space complexity
# n = max(nums)
# time: O(n)
# space: O(n)
            