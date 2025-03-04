class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        if(n%4!=0)return false;
        if((n&(n-1))!=0)return false;
        String binary = Integer.toBinaryString(n);
        System.out.println(binary);
        return binary.length()%2==1;
        
    }
}