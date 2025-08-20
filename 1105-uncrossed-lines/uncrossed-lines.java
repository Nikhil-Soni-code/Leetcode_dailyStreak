class Solution {
    private int find(int[] nums1,int[] nums2,int i,int j,int[][] dp){
        if(i==0||j==0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int matched = 0,notMatched = 0;
        if(nums1[i-1]==nums2[j-1]){
            matched = 1+find(nums1,nums2,i-1,j-1,dp);
        }
        else{
            notMatched = Math.max(find(nums1,nums2,i-1,j,dp),find(nums1,nums2,i,j-1,dp));
        }
        dp[i][j] = Math.max(matched,notMatched);
        return Math.max(matched,notMatched);
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return find(nums1,nums2,nums1.length,nums2.length,dp);
    }
}