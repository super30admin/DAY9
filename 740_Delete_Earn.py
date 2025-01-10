# Time: O(max(max element, size of array nums))
# Space: O(max element)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        #finding max element
        max_v=0
        for n in nums:
            max_v= max(max_v,n)
        arr = [0 for _ in range(max_v +1)]
        skip = 0 
        take = 0
        for n in nums:
            arr[n] = arr[n]+ n


        for n in arr:
            tempskip=skip
            skip= max(skip,take)
            take = n +tempskip
            print(skip,take)
        return max(skip,take)
        

        
