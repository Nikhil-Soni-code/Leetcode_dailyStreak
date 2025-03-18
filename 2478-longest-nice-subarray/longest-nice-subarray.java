class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int ans = 1;
        int num = 0;
        while(end<nums.length){
            while((num&nums[end])!=0){
                ans = Math.max(ans,end-start);
                num = num^nums[start];
                start++;
            }
            num = num|nums[end];
            end++;
        }
                ans = Math.max(ans,end-start);
return ans;

    }
}