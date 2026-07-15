class Solution {
    private int gcd(int a,int b){
        if(a==0)return b;
        if(b==0)return a;
        if(a>b){
            a = a%b;
        }else{
            b = b%a;
        }
        return gcd(a,b);
    }
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n*n;
        int sumEven = n*(n+1);
        return gcd(sumOdd,sumEven);
        
    }
}