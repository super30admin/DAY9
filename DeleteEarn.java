 // Time Complexity : O(m)  where m is the max value in the input nums
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

/* organize the input to have the total product of the occurance of each number.
by ordering the input, we can determine 2 outcomes at each step. If we choose current element then we cant chose the previous or next index. 
If we dont choose current element then the max points is equal to the previous iteration, If we choose the current element then the maximum is the sum of current element and previous's previous iteration.
The last element gives the solution.
*/
public class DeleteEarn{
    public int deleteAndEarn(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max)
                max = n;
        }
        int[] maxcounts = new int[max+1];

        for (int n : nums) {
            maxcounts[n] += n;
        }

        int prev = maxcounts[0];
        int curr = maxcounts[1];

        for (int i = 2; i <= max; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + maxcounts[i]);
            prev = temp;
        }

        return curr;

    }
}