class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count=0;
        int beg=0;
        int end=0;

        for(int i=0;i<nums.length;i++){
            beg=i+1;
            end=nums.length-1;
            while(beg<=end){
                int mid=beg+(end-beg)/2;
                if(nums[i]+nums[mid]>=lower){
                    end=mid-1;
                }
                else{
                    beg=mid+1;
                }
            }
            int start=beg;
            beg=i+1;
            end=nums.length-1;
            while(beg<=end){
                int mid=beg+(end-beg)/2;
                if(nums[i]+nums[mid]<=upper){
                    beg=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            int last=end;

            count+=last-start+1;
        }
        return count;
    }
}