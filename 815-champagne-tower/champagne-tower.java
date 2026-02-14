class Solution {
    private double find(int poured,int i,int j,double[][] dp){
        if(j<0 || i<0 || i<j)return 0;
        if(i==0 && j==0)return poured;
        if(dp[i][j] != -1.0)return dp[i][j];
        double leftCup = (find(poured,i-1,j-1,dp)-1)/2;
        double rightCup = (find(poured,i-1,j,dp)-1)/2;
        if(leftCup<0)leftCup = 0;
        if(rightCup<0)rightCup = 0;
        dp[i][j] = leftCup + rightCup;
        return leftCup + rightCup;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+1][query_row+1];
        for(double[] a:dp)Arrays.fill(a,-1.0);
        return Math.min(1.0, find(poured, query_row, query_glass, dp));
    }
}
