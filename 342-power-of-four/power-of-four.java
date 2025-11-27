class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<0)return false;
        if((n&(n-1))!=0)return false;
        int countBits = 0;
        while(n!=0){
            countBits++;
            n = n>>1;
        }
        return countBits%2==1;
    }
}