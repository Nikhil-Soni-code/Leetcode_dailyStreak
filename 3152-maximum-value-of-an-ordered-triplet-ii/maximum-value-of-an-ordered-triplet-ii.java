class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        long maxi=0;
        long maxDiff=0;

        for(int k=0;k<nums.length;k++){
            ans = Math.max(ans,(long)(maxDiff*nums[k]));
            maxDiff = Math.max(maxDiff,maxi-nums[k]);
            maxi = Math.max(maxi,nums[k]);
        }
        return ans;
    }
}