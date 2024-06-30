#time= O(nlogn) 
#space = O(n)
def deleteAndEarn(nums):
    if not nums:
        return 0
    
    # Step 1: Calculate the total points for each number
    points = {}
    for num in nums:
        points[num] = points.get(num, 0) + num
    
    # Step 2: Sort the unique numbers
    unique_nums = sorted(points.keys())
    
    # Step 3: Use dynamic programming to find the maximum points
    prev = None
    avoid = using = 0
    
    for num in unique_nums:
        if prev is not None and num == prev + 1:
            # If the current number is consecutive to the previous number
            new_avoid = max(avoid, using)
            new_using = avoid + points[num]
        else:
            # If the current number is not consecutive to the previous number
            new_avoid = max(avoid, using)
            new_using = new_avoid + points[num]
        
        avoid, using = new_avoid, new_using
        prev = num
    
    return max(avoid, using)

# Example usage
nums = [3, 4, 2]
print(deleteAndEarn(nums))  # Output: 6