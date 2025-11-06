class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        System.out.print(pivot);
        int left = binarySearch(nums,target,0,pivot);
        if(left!=-1)return left;
        int right = binarySearch(nums,target,pivot+1,nums.length-1);
        return right;
    }
    private int findPivot(int[] nums){
        int beg = 0,end = nums.length-1;
        while(beg<end){
            int mid = beg+(end-beg)/2;
            if(mid+1<nums.length&&nums[mid]>nums[mid+1]){
                return mid;
            }if(mid-1>=0&&nums[mid-1]>nums[mid]){
                return mid-1;
            }
            else if(nums[beg]>nums[mid]){
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return beg;
    }
    private int binarySearch(int[] nums,int target,int beg,int end){
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(nums[mid]==target)return mid;
            if(target<nums[mid]){
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }return -1;
    }
}