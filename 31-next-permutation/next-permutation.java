class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        for(;i>=0;i--){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        if(i==-1){
            Arrays.sort(nums);
            return;
        }
        //find the just greater element than nums[i]
        int max = Integer.MAX_VALUE;
        int maxIdx = -1;
        for(int j=i+1;j<nums.length;j++){
            if(nums[j]>nums[i]&&nums[j]<max){
                max = nums[j];
                maxIdx = j;
            }
        }
        int temp = nums[i];
        nums[i] = nums[maxIdx];
        nums[maxIdx] = temp;
        for(int j=i+1;j<nums.length;j++){
            for(int k=j+1;k<nums.length;k++){
                if(nums[j]>nums[k]){
                    temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                }
            }
        }


    }
}