class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        max_n = max(nums)  # Find the maximum value in nums

        # Create an array of the combined profits earned by choosing each unique element in nums
        arr = [0] * (max_n + 1)  # Ensure arr is properly sized

        for num in nums:
            arr[num] += num

        # Now apply the dynamic programming approach on the profits arr we created above
        prev = 0
        curr = 0

        for i in range(max_n + 1):  # Loop through all elements from 0 to max_n
            temp = curr
            curr = max(curr, prev + arr[i])
            prev = temp

        return curr

        # time complexity for dynamic prog is 0(n+m)
        # space complexity is O(m) where m is the max_n
