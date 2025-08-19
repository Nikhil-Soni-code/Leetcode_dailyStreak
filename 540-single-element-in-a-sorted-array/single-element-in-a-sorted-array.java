class Solution {
    public int singleNonDuplicate(int[] nums) {
        int beg = 0,end = nums.length-1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(mid-1>=0&&nums[mid]==nums[mid-1]){
                if(mid%2==0){
                    end = mid-1;
                }else{
                    beg = mid+1;
                }
            }else if(mid+1<nums.length&&nums[mid]==nums[mid+1]){
                if(mid%2==0){
                    beg = mid+1;
                }else{
                    end = mid-1;
                }
            }
            else{
                return nums[mid];
            }
        }
        return -1;
    }
}