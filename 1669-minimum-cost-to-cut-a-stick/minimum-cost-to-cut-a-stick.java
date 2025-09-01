class Solution {
    private int find(List<Integer> cost,int i,int j,int[][] dp){
        if(i>j)return 0;
        int ans = Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        for(int k=i;k<=j;k++){
            int totalCost = cost.get(j+1)-cost.get(i-1)+find(cost,i,k-1,dp)+find(cost,k+1,j,dp);
            ans = Math.min(ans,totalCost);
        }
        dp[i][j] = ans;
        return ans;
    }
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList();
        for(int i=0;i<cuts.length;i++){
            list.add(cuts[i]);
        }
        list.add(0);
        list.add(n);
        Collections.sort(list);
        int[][] dp = new int[cuts.length+1][cuts.length+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return find(list,1,cuts.length,dp);


    }
}