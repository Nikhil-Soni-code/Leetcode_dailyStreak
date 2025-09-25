// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int[] dp = new int[triangle.get(triangle.size()-1).size()];
//         Arrays.fill(dp,Integer.MAX_VALUE);
//         dp[0] = triangle.get(0).get(0);
//         for(int i=1;i<triangle.size();i++){
//             for(int j=triangle.get(i).size()-1;j>=0;j--){
//                 int x=dp[j],y=Integer.MAX_VALUE;
//                 if(j>0)y = dp[j-1];
//                 dp[j] = Math.min(x,y)+triangle.get(i).get(j);
//             }
//         }
//                 int min = Integer.MAX_VALUE;
//         for (int val : dp) {
//             min = Math.min(min, val);
//         }
//         return min;
//     }
// }
class Solution {
    private int find(List<List<Integer>> triangle,int row,int col,int[][] dp){
        if(row==triangle.size()){
            return 0;
        }
        if(dp[row][col]!=Integer.MIN_VALUE)return dp[row][col];
        int pick = triangle.get(row).get(col)+find(triangle,row+1,col,dp);
        int pickNext = Integer.MAX_VALUE;
        if(triangle.get(row).size()>col+1){
            pickNext = triangle.get(row).get(col+1)+find(triangle,row+1,col+1,dp);
        }
        dp[row][col] = Math.min(pick,pickNext);
        return Math.min(pick,pickNext);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][]dp = new int[triangle.size()][];
        for(int i=0;i<triangle.size();i++){
            dp[i] = new int[triangle.get(i).size()];
        }
        for(int a[]:dp){
            Arrays.fill(a,Integer.MIN_VALUE);
        }
        return find(triangle,0,0,dp);
    }
}