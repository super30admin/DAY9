import java.util.*;
class HouseRobber {
    public int rob(int[] nums) {
        int n= nums.length;
      int prev = nums[0];
      if(n==1)
      return nums[0];
      int cur = Math.max(nums[0], nums[1] + 0);
      for(int i=2;i<nums.length;i++)
      {  int temp= cur;
         cur = Math.max(cur, nums[i]+prev);
        prev = temp;
      } 

      return cur;
    }
//tc: O(n)
//sc: O(1) space
}