class Solution {
    private int countBits(int n){
        int count=0;
        while(n!=0){
            n=n>>1;
            count++;
        }
        return count;
    }
    public int smallestNumber(int n) {
        int i=n;
        while(true){
            if(countBits(i)==Integer.bitCount(i)){
                break;
            }i++;
        }
        return i;
    }
}