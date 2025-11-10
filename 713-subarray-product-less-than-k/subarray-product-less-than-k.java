class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i =0,j=0;
        int pro = 1,count = 0;
        while(j<nums.length){
            pro*=nums[j];
            while(i<=j&&pro>=k){
                pro/=nums[i++];
            }
            count+=j-i+1;
            j++;
        }return count;
    }
}