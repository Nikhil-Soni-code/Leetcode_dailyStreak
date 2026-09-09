class Solution {
    public long countCommas(long n) {
        long lower = 1000;
        int comma = 1;
        long ans = 0;
        while(lower<=n){
            long upper = (lower*1000)-1;
            if(upper>n)upper = n;
            ans += (upper-lower+1)*comma;
            comma++;
            lower = (lower*1000);
        }   return ans;
    }
}