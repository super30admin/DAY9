#t.c = O(M+N)
#sc = O(N)

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        p = {}
        max_num = 0
        for num in nums:
            p[num] = p.get(num, 0) + num  
            max_num = max(max_num, num)  

        prev = 0  
        curr = 0  
        
        for num in range(max_num + 1):  
            new_curr = max(curr, prev + p.get(num, 0))  
            prev = curr
            curr = new_curr
        
        return curr
