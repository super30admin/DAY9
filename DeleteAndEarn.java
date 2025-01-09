// Time Complexity : O ( max(n, maxElem) )
// Space Complexity : O ( maxElem )
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;
import java.util.Map;

/*
 * By storing each element up to the max along with their respective values
 * we can convert this to a house-robber pattern
 * We can use a map to store the pairs, or an array - an array would
 * be faster and simpler to code, but would need up to maxElem space
 * A map would be slightly slower and need a condition for when the element
 * is not present but would be more space efficient, especially if the
 * elements are sparsely distributed.
 */
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        // map to store each num with the total value
        // obtained by deleting that num
        Map<Integer, Integer> freqs = new HashMap<>();
        int max = 0;
        // find max element and compute
        // total values for each element
        for(int num: nums) {
            if (max < num) max = num;
            freqs.putIfAbsent(num, 0);
            freqs.compute(num, (_, v) -> v + num);
        }

        // do bottom up dp
        int skip = 0;
        int take = 0;

        // for each possible element up to max
        for(int i = 1; i <= max; i++) {
            // if the element is present
            if(freqs.containsKey(i)) {
                int tmp = skip;
                // if we skip the element, total value so far
                // will be max of previous skip, take
                skip = Math.max(skip, take);

                // if we take the element, total value so far
                // will be previous skip + current value
                take = tmp + freqs.get(i);
            } else {
                // if the element is not present, just take the max value possible
                // for both skip and take (for the next calculation)
                take = Math.max(skip, take);
                skip = take;
            }
        }
        // at the end, return the max of skip, take
        return Math.max(skip, take);
    }
}