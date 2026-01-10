class Solution {
    private int findMinimumDeletions(String s1,String s2,int i,int j,int[][] dp){
        if(i<0 && j<0){
            return 0;
        }
        if(i<0){
            int delete = 0;
            while(j>=0)delete+=s2.charAt(j--);
            return delete;
        }
        if(j<0){            
            int delete = 0;
            while(i>=0)delete+=s1.charAt(i--);
            return delete;
        }
        if(dp[i][j] != -1)return dp[i][j];
        int noDelete = Integer.MAX_VALUE;
        if(s1.charAt(i) == s2.charAt(j)){
            noDelete = 0 + findMinimumDeletions(s1,s2,i-1,j-1,dp);
        }
        int delete1st = s1.charAt(i) + findMinimumDeletions(s1,s2,i-1,j,dp);
        int delete2nd = s2.charAt(j) + findMinimumDeletions(s1,s2,i,j-1,dp);
        dp[i][j] = Math.min(noDelete,Math.min(delete1st,delete2nd));
        return Math.min(noDelete,Math.min(delete1st,delete2nd));
        
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return findMinimumDeletions(s1,s2,s1.length()-1,s2.length()-1,dp);
    }
}