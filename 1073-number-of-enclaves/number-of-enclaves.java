class Solution {
    private int count(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || grid[i][j]==0)return 0;
        if(grid[i][j]==1 && (i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1))return -1;

        grid[i][j] = 0;
        int a = count(grid,i-1,j);
        int b = count(grid,i,j-1);
        int c = count(grid,i,j+1);
        int d = count(grid,i+1,j);

        if(a==-1 || b==-1 || c==-1 || d==-1)return -1;
        return 1+a+b+c+d;

    }
    public int numEnclaves(int[][] grid) {
        int ans = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]==1){
                    int co = count(grid,i,j);
                    if(co!=-1){
                        ans+=co;
                    }
                }
            }
        }
        return ans;
    }
}