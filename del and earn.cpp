// del and earn
// similar to house robber
class Solution {
public:
	int deleteAndEarn(vector<int>& nums) {
		vector<int> cnt(10002); // or hash map
		for(int i=0;i<nums.size();i++)
		{
			cnt[nums[i]]+=nums[i];
		}

		vector<int> dp(10002); // can maintain a max while filling hash map or eliminate dp array altogether and just have 3 vars - result/max, prev, curr
		dp[1]=cnt[1];
		dp[2]=max(cnt[1],cnt[2]);
		for(int i=3;i<dp.size();i++)
		{
			dp[i]=max(dp[i-2]+cnt[i],dp[i-1]);
		}

		return max(dp[10000],dp[9999]);
	}
};