// Time Complexity : O(n)
// Space Complexity : O(maxNums)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach - converted the nums array into
//arr with each position having the points. Then it was similar to the house robber problem approach


/**
 * DeleteAndEarn : DeleteAndEarn
 *
 * @author : Kavya Mandaliya
 * @version : 1.0 (Nov 06, 2024)
 * @since : 1.0 (Nov 06, 2024)
 */
public class DeleteAndEarn {
 public int deleteAndEarn(int[] nums) {
  int maxNums = Integer.MIN_VALUE;
  for(int i: nums){
   maxNums = Math.max(maxNums, i);
  }

  int arr[] = new int[maxNums+1];
  for(int i : nums){
   arr[i] += i;
  }
  int prev= arr[0];
  int curr = Math.max(prev, arr[1]);
  for(int i = 2; i <= maxNums; i++){
   int tmp = curr;
   curr = Math.max(curr, arr[i]+prev);
   prev = tmp;
  }
  return curr;
 }
}
