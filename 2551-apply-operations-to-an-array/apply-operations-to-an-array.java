class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
        }
        int i=0;
        while(i<nums.length){
            if(nums[i]==0){
                break;
            }
            i++;
        }
        int j=i;
        while(j<nums.length){
            if(nums[j]!=0){
                nums[i]=nums[j];
                nums[j]=0;
                i++;
            }
            j++;
        }
        return nums;
    }
}