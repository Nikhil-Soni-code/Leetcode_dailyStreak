class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0){
                int j = i;
                while(j<i+3&&j<nums.length){
                    nums[j] = nums[j]^1;j++;
                }
                count++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                return -1;
            }
        }
        return count;
    }
}