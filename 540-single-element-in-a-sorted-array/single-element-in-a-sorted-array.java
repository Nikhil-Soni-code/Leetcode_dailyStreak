class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(nums[0]!=nums[1])return nums[0];
        if(nums[n-1]!=nums[n-2])return nums[n-1];

        int beg = 1;
        int end = n-2;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if((nums[mid]==nums[mid-1]&& mid%2==0) || nums[mid]==nums[mid+1] && mid%2==1){
                end=mid-1;
            }
            else{
                beg=mid+1;
            }
        }
        return -1;


    }
}