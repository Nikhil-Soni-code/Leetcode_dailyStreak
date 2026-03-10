class Solution {
    private int dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0)return 0;
        int fish = grid[i][j];
        grid[i][j] = 0;
        int a = dfs(grid,i+1,j);
        int b = dfs(grid,i,j+1);
        int c = dfs(grid,i,j-1);
        int d = dfs(grid,i-1,j);

        return fish + a+b+c+d;
    }
    public int findMaxFish(int[][] grid) {
        int ans = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }
}