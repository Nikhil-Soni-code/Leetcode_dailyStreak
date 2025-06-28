class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            for(int j=triangle.get(i).size()-1;j>=0;j--){
                int x=dp[j],y=Integer.MAX_VALUE;
                if(j>0)y = dp[j-1];
                dp[j] = Math.min(x,y)+triangle.get(i).get(j);
            }
        }
                int min = Integer.MAX_VALUE;
        for (int val : dp) {
            min = Math.min(min, val);
        }
        return min;
    }
}
// class Solution {
//     private int find(List<List<Integer>> triangle,int i,int row,int[][] dp){
//         if(row==triangle.size())return 0;
//         if(dp[row][i]!=-1)return dp[row][i];
//         int pick_i = find(triangle,i,row+1,dp);
//         int pick_nexti = find(triangle,i+1,row+1,dp);
//         dp[row][i] = triangle.get(row).get(i)+Math.min(pick_i,pick_nexti);
//         return dp[row][i];

//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int[][]dp = new int[triangle.size()][];
//         for(int i=0;i<dp.length;i++){
//             dp[i] = new int[triangle.get(i).size()];
//             Arrays.fill(dp[i],-1);
//         }
//         return find(triangle,0,0,dp);

//     }
// }