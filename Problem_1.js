// Time Complexity : O(n+m); where n in number of input elements and m is range from 0 to maximum element in the nums array.
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Applied bottom up approach of dp to solve the problem. Similar to house robber on preprocessed data as taught in class;
/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function(nums) {
    
    let res = [];
    let maxEle = -1;
    for(let i=0;i< nums.length; i++){
        maxEle = Math.max(maxEle, nums[i]);
    }
    for(let i=0; i<=maxEle; i++){
        res[i] = 0;
    }

    for(let i=0; i<nums.length; i++){
            res[nums[i]]+= nums[i];
        
    }

    res[1] = Math.max(res[1], res[0]);
    for(let i=2; i<=maxEle; i++){
        res[i] = Math.max(res[i] + res[i-2], res[i-1]);
    }
    
    return res[res.length-1];
};