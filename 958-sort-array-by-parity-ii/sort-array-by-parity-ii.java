class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0,j=1,k=0;k<nums.length;k++){
            if(nums[k]%2==0){ans[i]=nums[k];i+=2;}
            else{ans[j]=nums[k];j+=2;}
        }return ans;
    }
}