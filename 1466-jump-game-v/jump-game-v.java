class Solution {
    private int find(int[] arr,int d,int i,int[] dp){
        if(dp[i]!=-1)return dp[i];
        boolean flag1 = true, flag2 = true;
        int max = 0;
        for(int x=1 ; x<=d ; x++){
            int path1 = 0,path2 = 0;
            if(flag1 && i-x>=0 && arr[i-x] < arr[i]){
                path1 = find(arr,d,i-x,dp);
            }else{
                flag1 = false;
            }

            if(flag2 && i+x<arr.length && arr[i+x] < arr[i]){
                path2 = find(arr,d,i+x,dp);
            }else{
                flag2 = false;
            }
            max = Math.max(max,Math.max(path1,path2));
        }
        dp[i] = max+1;
        return max+1;
    }
    public int maxJumps(int[] arr, int d) {
        int max = 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        for(int i=0 ; i<arr.length ; i++){
            max = Math.max(max,find(arr,d,i,dp));
        }
        return max;
    }
}