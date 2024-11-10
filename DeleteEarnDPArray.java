/*
    Time Complexity : O(n) + O(max(n)) meaning maximum between O(n) and O(max(n)) and we don't know which is maximum
                    O(n) traversing over entire arrays to convert to freq array and O(max(n)) is max(n) is the size
                    of freq array

    Space Complexity : O(max(n)) as we are creating freq array

    Did this code successfully run on Leetcode : Yes

    Greedy won't work because if we go for maximum number or maximum frequency number it may
    or may not give the max earnings
 */

class DeleteEarnDPArray {
    public int deleteAndEarn(int[] nums) {

        //First we need to create the frequency array
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            max = Math.max(max, num);
        }

        int[] freqArr = new int[max+1]; //starts from 0 so max+1

        for(int num : nums) {
            //filling freqArr
            freqArr[num] += num; //if number is 4, add it in the 4th index, so add all occurrances
        }

        int prev = freqArr[0];
        int curr = Math.max(freqArr[0], freqArr[1]);

        for(int i=2; i<=max; i++) {
            int temp = curr;
            curr = Math.max(curr, freqArr[i]+prev);
            prev = temp;
        }

        return curr;
    }

}