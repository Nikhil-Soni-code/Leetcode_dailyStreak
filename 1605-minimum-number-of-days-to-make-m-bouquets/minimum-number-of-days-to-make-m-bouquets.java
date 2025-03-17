class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)return -1;
        int beg = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            end = Math.max(end,bloomDay[i]);
            beg = Math.min(beg,bloomDay[i]);
        }
        int ans = -1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            int count = 0;
            int flowerCount = 0;
            for(int i=0;i<bloomDay.length;i++){
                if(bloomDay[i]<=mid){
                    count++;
                }
                else{
                    count=0;
                }
                if(count==k){
                    flowerCount++;
                    count=0;
                }
            }
            if(flowerCount>=m){
                ans = mid;
                end = mid-1;
            }
            else{
                beg = mid+1;
            }
        }
        return ans;

    }
}