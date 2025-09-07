class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        if(n%2==0){
            int idx = 0;
            for(int i=-n/2;i<=n/2;i++){
                if(i==0){
                    continue;
                }
                ans[idx++] = i;
            }
        }else{  
            int idx = 0;
            for(int i=-n/2;i<=n/2;i++){
                ans[idx++] = i;

            }
        }return ans;

    }
}