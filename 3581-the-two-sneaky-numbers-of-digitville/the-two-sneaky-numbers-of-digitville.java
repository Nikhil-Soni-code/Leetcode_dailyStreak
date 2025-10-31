class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int i = 0;
        while(i<nums.length){
            int correct = nums[i];
            if(nums[i]!=nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else{
                i++;
            }
        }
        int idx = 0;
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i){
                ans[idx++] = nums[i];
            }
            if(idx==2)return ans;
        }
        return ans;
    }
}