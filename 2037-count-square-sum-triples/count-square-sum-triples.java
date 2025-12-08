class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int target = (i*i) + (j*j);
                int beg = 1,end = n;
                if(binarySearch(beg,target,end))count++;
            }
        }return count;
    }
    private boolean binarySearch(int beg,int target,int end){
        
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            int sqr = mid*mid;
            if(target==sqr)return true;
            if(target<sqr)end = mid-1;
            else beg = mid+1;
        }return false;
    }
}