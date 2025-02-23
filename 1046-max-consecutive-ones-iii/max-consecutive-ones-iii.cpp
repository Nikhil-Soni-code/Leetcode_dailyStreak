class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int end = 0, start = 0;
        int count = 0, maxsum = 0, sum = 0;

        while (end < nums.size()) {
            sum++;
            if (nums[end] == 0) {
                count++;
            }
            
            if (count > k) {
                maxsum = max(maxsum, sum - 1); // Store max before shrinking
                while (count > k) {
                    if (nums[start] == 0) {
                        count--;
                    }
                    sum--;
                    start++;
                }
            }
            
            end++;
        }
        
        maxsum = max(maxsum, sum); // Final update of maxsum
        return maxsum;
    }
};
