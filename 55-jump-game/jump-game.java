class Solution {
    public boolean canJump(int[] nums) {
        int farPoint = 0;
        for(int i=0;i<nums.length;i++){
            if(i>farPoint)return false;
            farPoint = Math.max(farPoint,nums[i]+i);
        }
        return true;
    }
}