class Solution {
    public int[] countBits(int n) {

        int[] ans = new int[n+1];
        ans[0] = 0;
        if(n==0)return ans;
        ans[1] = 1;
        if(n==1)return ans;

        for(int i=2;i<=n;i++){
            if(i%2==0){
                ans[i] = ans[i/2];
            }
            else{
                ans[i] = ans[i-1]+1;
            }

        }return ans;
    }
}