class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for(int[] a:grid){
            int beg = 0,end = a.length-1;
            while(beg<=end){
                int mid = beg+(end-beg)/2;
                if(a[mid]>=0)beg = mid+1;
                else end = mid-1;
            

            
            }
            ans+=a.length-beg;

        }
        return ans;
    }
}