class Solution {
    int MOD = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        long prefix = 1;
        int[][] ans = new int[grid.length][grid[0].length];
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                ans[i][j] = (int)prefix;
                prefix = (prefix*grid[i][j])%MOD;
            }
        }
        long suffix = 1;
        for(int i=grid.length-1 ; i>=0 ; i--){
            for(int j=grid[0].length-1 ; j>=0 ; j--){
                ans[i][j] = (int)(ans[i][j]*suffix)%MOD;
                suffix = (suffix*grid[i][j])%MOD;

            }
        }
        return ans;
    }
}