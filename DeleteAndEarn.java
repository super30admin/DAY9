// Time Complexity : O(n)
// Space Complexity : O(max(nums)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * We calculate the sum of identical elements. Iterate through array and find the 'max' value. Create a new array of 'max' elements. At each index of new array
 * we store the sum of index values in original array. Then we apply the house robber formula to find the max points earned. 
 */
public class DeleteAndEarn {

    //adjacent number cannot be taken
    public int deleteAndEarn(int[] nums) {
        //O(m+n) = O(max(n)+n)
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        //o(n)
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        //O(m)
        int[] arr=new int[max+1];
        for(int i=0;i<n;i++){
            int x=nums[i];
            arr[x]=arr[x]+x;
        }
        //house robber pattern
        //o(m)
        int prev=arr[0];
        int curr=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            int tmp=curr;
            curr=Math.max(curr,arr[i]+prev);
            prev=tmp;
        }
        return curr;
    }
}
