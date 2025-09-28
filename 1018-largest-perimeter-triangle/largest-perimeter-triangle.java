class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int k=nums.length-1;k>1;k--){
            int i=0,j=k-1;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                    ans = Math.max(ans,nums[i]+nums[j]+nums[k]);
                }
                    i++;
            }
        }
        return ans;
    }
}