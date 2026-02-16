class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int pow = 31;
        while(n!=0){
            if((n&1)==1)ans += (1<<pow);
            pow--;
            n = n>>1;
        }
        return ans;
    }
}