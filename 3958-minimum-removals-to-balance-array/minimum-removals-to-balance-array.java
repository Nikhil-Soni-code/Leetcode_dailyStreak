class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[nums.length-1] <= (long)(nums[0]*k))return 0;
        int i = 0,j = 0;
        int ans = nums.length-1;
        while(j<nums.length){
            long pro = ((long)nums[i]*k);
            if((long)nums[j] <= pro){
                ans = Math.min(ans,nums.length-j-1 + i);
                j++;
            }else{
                i++;
            }
        }return ans;
    }
}