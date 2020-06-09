// Time Complexity: O(max(m,n)) where m -> maximum value in array  and n -> size of the input array
// Space Complexity: O(m) -> m is the maximum value in the array.

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 0;

        for(int num : nums){
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];

        for(int num: nums){
            arr[num] = arr[num] + num;
        }

        int skip = 0, take = 0;

        for(int i = 1 ; i < arr.length ; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }

        return Math.max(skip, take);

    }
}
