class Solution {
    public int kthFactor(int n, int k) {
        int i=0;
        for(i=1;i<=n;i++){
            if(n%i==0){
                k--;
            }
            if(k==0){
                break;
            }
        }
        return (k==0)?i:-1;
    }
}