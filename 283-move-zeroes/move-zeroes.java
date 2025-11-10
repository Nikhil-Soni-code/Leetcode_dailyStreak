class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(;i<nums.length;i++){
            if(nums[i]==0)break;
        }
        int j = i+1;
        while(j<nums.length){
            if(nums[j]!=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }j++;
        }
    }
}