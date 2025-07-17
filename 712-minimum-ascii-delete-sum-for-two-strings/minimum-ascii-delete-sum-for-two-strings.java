class Solution {
    private int find(String s1,String s2,int i,int j,int[][] dp){
        if(i==0){
            int remove = 0;
            for(int k=j-1;k>=0;k--){
                remove+=(int)s2.charAt(k);
            }
            return remove;
        }
        if(j==0){
            int remove = 0;
            for(int k=i-1;k>=0;k--){
                remove+=(int)s1.charAt(k);
            }
            return remove;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            dp[i][j] = find(s1,s2,i-1,j-1,dp);
            return dp[i][j];
        }
        else{
            int remove1 = (int)s1.charAt(i-1)+find(s1,s2,i-1,j,dp);
            int remove2 = (int)s2.charAt(j-1)+find(s1,s2,i,j-1,dp);
            dp[i][j] = Math.min(remove1,remove2);
            return dp[i][j];
        }
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return find(s1,s2,s1.length(),s2.length(),dp);
        
    }
}