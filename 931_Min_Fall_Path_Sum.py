#time: O(n*n)
#space: O(n*n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n= len(matrix)
        arr= list(matrix)
        for r in range(1,n):
            for c in range(n):
                if(c ==0):
                    arr[r][c]= arr[r][c]+ min(arr[r-1][c], arr[r-1][c+1])
                elif(c == n-1):
                    arr[r][c]= arr[r][c]+ min(arr[r-1][c], arr[r-1][c-1])
                else:
                    arr[r][c]= arr[r][c]+ min(arr[r-1][c], min(arr[r-1][c-1],arr[r-1][c+1]))
        min_v =float('inf')

        for c in range(n):
            min_v= min(min_v,arr[n-1][c])
        return min_v
        
