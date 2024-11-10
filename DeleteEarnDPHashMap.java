import java.util.HashMap;

/*
    Time Complexity : O(n) + O(max(n)) meaning maximum between O(n) and O(max(n)) and we don't know which is maximum
                    O(n) traversing over entire arrays to convert to hash map and O(max(n)) is max(n) is the size
                    of hash map on which we iterate.

    Space Complexity : O(n) where n is the number of unique elements in nums. This is because the primary space used
                        is for the map, which stores up to n entries.

                        The map is used to store the frequency of each unique number in nums, with the number as the key
                        and its contribution (sum of occurrences of that number) as the value. In the worst case,
                        if all elements in nums are unique, the map will contain O(n) entries, where n is the number
                        of elements in nums.
 */
class DeleteEarnDPHashMap {

        public int deleteAndEarn(int[] nums) {

            //First we need to create the frequency array
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int num : nums) {
                max = Math.max(max, num);
                min = Math.min(min, num);
                map.put(num, map.getOrDefault(num, 0)+num);
            }

            int prev = map.get(min);

            //Suppose 5 is not there in hashmap so the freq in array approach was 0 so here we put curr as prev
            //and also check if map contins 5, if yes update it from prev to new value
            int curr = 0;
            if(map.containsKey(min+1)) {
                curr = Math.max(prev, map.get(min+1));
            }
            else {
                curr = Math.max(prev, 0);
            }

            for(int i=min+2; i<=max; i++) {
                int temp = curr;

                if(map.containsKey(i)) {
                    curr = Math.max(curr, map.get(i)+prev);
                } else {
                    curr = Math.max(curr, 0+prev);
                }

                prev = temp;
            }

            return curr;
        }
}