class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int i=0,j=0;
        while(j<nums.length){
            if(nums[j]==0){
                ans+=j-i+1;
                j++;
            }else{
                j++;
                i=j;
            }
        }
        return ans;
    }
}