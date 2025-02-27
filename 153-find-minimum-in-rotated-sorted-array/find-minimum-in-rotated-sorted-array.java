class Solution {
    public int findMin(int[] nums) {
        int beg=0;
        int end=nums.length-1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(mid+1<nums.length&&nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(mid-1>=0&&nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[beg]>nums[mid]){
                end=mid-1;
            }
            else{
                beg=mid+1;
            }
        }
        return nums[0];

    }
}