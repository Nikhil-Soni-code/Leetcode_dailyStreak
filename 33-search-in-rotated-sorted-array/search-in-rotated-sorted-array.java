class Solution {
    private int findPeak(int[] nums){
        int beg = 0,end = nums.length-1;
        while(beg<end){
            int mid = beg+(end-beg)/2;
            if(mid+1<nums.length&&nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid-1>=0&&nums[mid]<nums[mid-1])return mid-1;
            if(nums[beg]>nums[mid]){
                end = mid-1;
            }
            else{
                beg = mid+1;
            }
        }
        return beg;
    }
    private int bs(int beg,int[] nums,int target,int end){
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]>target){
                end = mid-1;
            }
            else{
                beg = mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int peak = findPeak(nums);
        int found = bs(0,nums,target,peak);
        if(found!=-1)return found;
        return bs(peak+1,nums,target,nums.length-1);
    }
}