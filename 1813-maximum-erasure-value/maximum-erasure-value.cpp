class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        int maxsum=0;
        int sum=0;
        unordered_set<int> ans;
        int end=0;
        int start=0;
        while(end<nums.size()){
            if(ans.find(nums[end]) == ans.end()){
                ans.insert(nums[end]);
                sum=sum+nums[end];
                maxsum=max(maxsum,sum);
                end++;
            }
            else{
                    ans.erase(nums[start]);
                    sum=sum-nums[start];
                    start=start+1;
             }
            
        }
        return maxsum;
    }
};