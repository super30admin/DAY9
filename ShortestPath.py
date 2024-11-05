def minFallingPathSum(matrix) -> int:
    for i in range(1, len(matrix)):
        
        matrix[i][0] = min(matrix[i][0]+matrix[i-1][1], matrix[i][0]+matrix[i-1][0])

        if len(matrix[0]) > 2:
            for j in range(1, len(matrix[0])-1):
                matrix[i][j] = min(matrix[i][j]+matrix[i-1][j], matrix[i][j]+matrix[i-1][j+1], matrix[i][j]+matrix[i-1][j-1])
        
        matrix[i][len(matrix[0])-1] = min(matrix[i][len(matrix[0])-1]+matrix[i-1][len(matrix[0])-1], matrix[i][len(matrix[0])-1]+matrix[i-1][len(matrix[0])-2])

    sum = matrix[len(matrix)-1][0]

    for i in range(1, len(matrix[0])):
        sum = min(sum, matrix[len(matrix)-1][i])
        
    return sum


matrix = [[100,-42,-46,-41],[31,97,10,-10],[-58,-51,82,89],[51,81,69,-51]]

print(minFallingPathSum(matrix))