// Time Complexity : O(n)+O(max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// approach: calculated the frequecy of each value of nums into new array.
// then calculated the max sum that can be earned by taking a dp array.

// Your code here along with comments explaining your approach


public class deletenearn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int max=0;
            for(int num:nums)
            {
                max=Math.max(num,max);
            }
            int[] arr=new int[max+1];
            arr[0]=0;
            for(int num:nums)
            {
                arr[num]+=num;
            }
            int prev=arr[0];
            int curr=Math.max(arr[0],arr[1]);
            for(int i=2;i<=max;i++)
            {
                int temp=curr;
                curr=Math.max(curr,prev+arr[i]);
                prev=temp;
            }
            return curr;
        }
    }
}
