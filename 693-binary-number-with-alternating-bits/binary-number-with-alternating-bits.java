class Solution {
    public boolean hasAlternatingBits(int n) {
        int prevBit = -1;
        while(n!=0){
            if((n&1)==1){
                if(prevBit == 1){
                    return false;
                }
                prevBit = 1;
            }
            else{
                if(prevBit == 0){
                    return false;
                }
                prevBit = 0;
            }
            n=n>>1;
        }
        return true;
    }
}