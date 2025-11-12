class Solution {
    public double myPow(double x, int pow) {
        long n = pow;
        if(n<0){
            x = 1/x;
            n = Math.abs(n);
        }
        double ans = 1;
        while(n>0){
            if(n%2==1){
                ans = ans*x;
                n--;
            }else{ 
            x = x*x;
            n/=2;}
        }
        return ans;
    }
}