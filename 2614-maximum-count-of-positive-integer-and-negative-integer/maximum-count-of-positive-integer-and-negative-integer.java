class Solution {
    public int maximumCount(int[] nums) {
        int beg = 0;
        int end = nums.length-1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(nums[mid]>=0){
                end = mid-1;
            }
            else{
                beg = mid+1;
            }
        }

        int negCount = end+1;
        beg = 0;
        end = nums.length-1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(nums[mid]>0){
                end = mid-1;
            }
            else{
                beg = mid+1;
            }
        }
        int posCount = nums.length-beg;
        return Math.max(negCount,posCount);


    }
}