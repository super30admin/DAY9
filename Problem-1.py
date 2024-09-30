
#Approach
# Every time we will choose or not choose the element if we choose same index will be passed to next
#recursive call else pass the next index to next recursive call and find the min.


# complexities
#Time Complexity : 2^(m+n)
#Space Complexity : O(N)


from typing import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix[0])
        rows = len(matrix)
        if n == 1 and rows == 1:
            return matrix[0][0]
        prev = [float("inf")] * (n + 2)

        for i in range(len(matrix[0])):
            prev[i + 1] = matrix[0][i]

        for i in range(1, len(matrix)):
            cur = [float("inf")] * (n + 2)
            for j in range(len(matrix[0])):
                cur[j + 1] = matrix[i][j] + min(prev[j + 1], prev[j], prev[j + 2])
            prev = cur

        return int(min(prev))