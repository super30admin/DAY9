class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        # # [1,1,1,2,2,4,5,5,5,6]
        #   [1 ,2 ,4, 5, 6]
        # 0  3, 4, 8, 19,19      

        if len(nums)== 0 or nums == None:
          return 0
        
        dict = {}
        dict[0] = 1
        for num in nums:
          if num not in dict:
            dict[num] = 0
          dict[num] += 1
        
        array= list(dict.keys())
        array.sort()
        dp = [0 for i in range(len(array))]

        for i in range(1,len(array)):
          if array[i] -1 == array[i-1]:
            dp[i] = max(dp[i-1], (array[i] * dict[array[i]]) + dp[i-2])
          else:
            dp[i] = (array[i] * dict[array[i]]) + dp[i-1]
        print(dp)
        return dp[len(dp)-1]


