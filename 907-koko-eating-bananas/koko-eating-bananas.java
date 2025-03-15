class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int beg = 1;//////
        int end = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            end = Math.max(end,piles[i]);
        }
        int ans = 0;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            int timeTaken = 0;
            for(int i=0;i<piles.length;i++){
                timeTaken += Math.ceil((double)piles[i]/mid);
            }
            if(timeTaken<=h){
                ans = mid;
                end = mid-1;
            }
            else beg = mid+1;
        }return ans;

    }
}