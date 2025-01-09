/*
Time COmplexity -> O(N) + O(N) + O(maxelement) -> O(N+maxElement)

Space COmplexity -> O(MAXElement)
*/



class Problem2 {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // To find the max element
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        // Creating a new array to hold the sum
        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            arr[index] = nums[i] + arr[index];
        }
        // DP solving
        int skip = 0;
        int take = 0;
        for (int i = 0; i < max + 1; i++) {
            int skipTemp = skip;
            skip = Math.max(skip, take);
            take = arr[i] + skipTemp;
        }
        return Math.max(skip, take);
    }
}