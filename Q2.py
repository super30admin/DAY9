############# Minimum Falling Path Sum

# Time Complexity : O(n^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Go through the array and compute the min for the current element

def min_path_sum(matrix):
    if not matrix:
        return 0
    
    for i in range(len(matrix)-2,-1,-1):
        for j in range(len(matrix)):
            if j == 0:
                matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
            elif j == len(matrix)-1:
                matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
            else:
                matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1], matrix[i+1][j-1])

    return min(matrix[0])


