#include<bits/stdc++.h>
#include <vector>
#include <iostream>
using namespace std;


int deleteAndEarn(vector<int>& nums) {
    unordered_map<int,int>freq;
    int n = nums.size();
    for(int i=0;i<=n-1;i++) freq[nums[i]]++;
    vector<pair<int,int>>unique;
    for(auto p:freq) unique.push_back(p);
    sort(unique.begin(),unique.end());
    n = unique.size();
    int dp[n+1];
    memset(dp,0,sizeof(dp));
    for(int i=n-1;i>=0;i--){
        pair<int,int> next_see = {unique[i].first+2,0};
        int next = lower_bound(unique.begin()+i,unique.end(),next_see)-unique.begin();
        dp[i] = max(dp[next]+unique[i].first*unique[i].second,dp[i+1]);
    }
    return dp[0];
}

int main(){
    vector<int> nums = {3,4,2};
    cout<<deleteAndEarn(nums);
    return 0;
}