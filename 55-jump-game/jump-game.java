class Solution {
    public boolean canJump(int[] nums) {
        int farPoint = 0;
        if(nums.length==1)return true;
        for(int i=0;i<nums.length-1;i++){
            
            if(farPoint<i)return false;
            farPoint = Math.max(farPoint,nums[i]+i);
            if(farPoint>=nums.length-1)return true;
        }return false;

         
    }
}