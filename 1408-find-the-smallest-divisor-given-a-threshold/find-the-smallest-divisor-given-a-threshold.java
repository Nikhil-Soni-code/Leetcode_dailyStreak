class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int beg = 1;
        int end = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            end = Math.max(end,nums[i]);
        }int ans = 0;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            int quotient = 0;
            for(int i=0;i<nums.length;i++){
                quotient+=Math.ceil((double)nums[i]/mid);
            }
            if(quotient<=threshold){
                ans = mid;
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return ans;
    }
}