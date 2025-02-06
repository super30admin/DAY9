// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int max_ = INT_MIN;
        for (auto n :nums) {
            max_ = max(max_, n);
        }
        vector<int> arr(max_+1, 0);
        for (int i=0; i<nums.size(); i++) {
            arr[nums[i]]+= nums[i];
        }

        int prev = arr[0];
        int curr = max(arr[0], arr[1] + 0);

        for (int i=2; i<arr.size(); i++) {
            int temp = curr;
            curr = max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;

    }
};