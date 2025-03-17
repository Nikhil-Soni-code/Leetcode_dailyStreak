class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int beg = 0;
        int end = 0;
        for(int i=0;i<weights.length;i++){
            beg = Math.max(beg,weights[i]);
            end+=weights[i];
        }
        int ans = 0;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            int noOfDays = 1;
            int weightCount = 0;
            for(int i=0;i<weights.length;i++){
                weightCount+=weights[i];
                if(weightCount>mid){
                    noOfDays++;
                    weightCount=weights[i];
                }
            }
            if(noOfDays<=days){
                ans = mid;
                end = mid-1;


            }else{
                beg = mid+1;

            }
        }
        return ans;
    }
}