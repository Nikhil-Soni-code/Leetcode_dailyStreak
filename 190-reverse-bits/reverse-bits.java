class Solution {
    public int reverseBits(int n) {
        int pow = 31;
        int ans = 0;
        while(n!=0){
            if((n&1)==1){
                ans = ans+(1<<pow);
            }
            pow--;
            n = n>>1;
        }return ans;
    }
}