class Solution {
    private int sum(int n){
        int ans = 0;
        while(n!=0){
            ans+=n%10;
            n = n/10;
        }return ans;
    }
    public int sumBase(int n, int k) {
        if(k==10){
            return sum(n);
        }
        n = baseConversion(n,k);
        return sum(n);
    }
    private int baseConversion(int n,int k){
        int ans = 0;
        int exp = 1;
        while(n>1){
            ans = (n%k)*exp+ans;
            n=n/k;
            exp *= 10;
        }return ans+n%k;
    }
}