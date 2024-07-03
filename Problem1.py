#I've used dynamic programming in this problem. It first counts the frequency of each number in nums and calculates the maximum number mx. It then builds a list comp where each element at index i represents the total points earned by deleting all occurrences of i. A memo list is used for memoization to store intermediate results. The dp function computes the maximum points up to index i by either taking the current element and adding its points to dp(i-2) or skipping it and using dp(i-1). Finally, dp(mx) returns the maximum points that can be earned. 
#The time complexity is O(n+k), where n is the number of elements in nums and k is the maximum value in nums. The space complexity is O(k), due to the space needed for the comp and memo lists.

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        cc=collections.Counter(nums)
        mx=max(cc)
        comp=[]
        for i in range(mx+1):
            if i in cc:
                comp.append(cc[i]*i)
            else:
                comp.append(0)
        memo=[-1 for _ in range(mx+1)]
        def dp(i):
            if i<0:
                return 0 
            elif memo[i]>=0:
                return  memo[i]
            else:
                res=max(dp(i-2)+comp[i],dp(i-1))
                memo[i]=res
                return res
        return dp(mx)