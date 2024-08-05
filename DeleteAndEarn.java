//Time Complexity: O(n)
//Space Complexity: O(n)
public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max + 1];
        for(int num : nums){
            arr[num] += num;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i=2;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
        }

        return dp[arr.length-1];

    }

    public static void main(String[] args){
        int[] nums = new int[]{2,2,3,3,3,4};
        int result = deleteAndEarn(nums);
        System.out.println("The maximum earning is :" + result);
    }
}
