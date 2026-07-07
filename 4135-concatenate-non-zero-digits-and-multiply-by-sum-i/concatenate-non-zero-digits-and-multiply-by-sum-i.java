class Solution {
    public long sumAndMultiply(int n) {
        long x = 0,sum = 0;
        int pow = 1;
        while(n!=0){
            if(n%10!=0){
                x = (n%10)*pow+x;
                pow*=10;
                sum += n%10;
            }
            n/=10;

        }
        return sum*x;
        
    }
}