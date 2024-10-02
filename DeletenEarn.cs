// Time Complexity : o(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int DeleteAndEarn(int[] nums) {
        int max =0;
        int min = int.MaxValue;
        Dictionary<int, int> map = new Dictionary<int,int>();

        foreach(int num in nums){
            min = Math.Min(min, num);
            max = Math.Max(max,num);
            map[num] = map.ContainsKey(num) ? map[num] + num : num;
        }
        

        int prev = map[min];
        int curr = prev;
        if(map.ContainsKey(min+1)){
            curr = Math.Max(prev, map[min+1]);
        }

        for(int i=min+2; i<=max; i++){
            int temp = curr;
            if(map.ContainsKey(i)){
                curr = Math.Max(curr, map[i]+prev);
            }
            else{
                curr = Math.Max(curr, 0+prev);
            }
            
            prev = temp;
        }
        
        return curr;
    }
}