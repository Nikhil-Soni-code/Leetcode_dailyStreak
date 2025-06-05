class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int idx1 = 0,idx2 = nums.length-1;
        int i=0,j=nums.length-1;
        while(i<=j){

            if(Math.abs(nums[i])<Math.abs(nums[j])){
                int num = Math.abs(nums[j])*Math.abs(nums[j]);
                ans[idx2--] = num;
                j--;
            }else{
                int num = Math.abs(nums[i])*Math.abs(nums[i]);
                ans[idx2--] = num;
                i++;
            }
        }
        return ans;
    }
}