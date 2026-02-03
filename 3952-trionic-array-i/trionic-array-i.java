class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length == 3)return false;
        int i = 0;
        while(i < nums.length-1){
            if(nums[i] >= nums[i+1])break;
            i++;
        }
        if(i==0 || i==nums.length-1){
            return false;
        }
        while(i < nums.length-1){
            if(nums[i] <= nums[i+1])break;
            i++;
        }
        if(i==nums.length-1){
            return false;
        }
        while(i < nums.length-1){
            if(nums[i] >= nums[i+1])break;
            i++;
        }
        return i==nums.length-1;
        
    }
}