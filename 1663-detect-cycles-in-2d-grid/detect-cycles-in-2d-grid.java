class Solution {
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    private boolean detectCycle(char[][] grid,int i,int j,int prev_i,int prev_j,boolean[][] visited){
        if(visited[i][j])return true;
        visited[i][j] = true;
        for(int k=0 ; k<4 ; k++){
            int new_i = i+directions[k][0];
            int new_j = j+directions[k][1];
            if(new_i == prev_i && new_j == prev_j)continue;
            if(new_i<0 || new_j<0 || new_i>=grid.length || new_j>=grid[0].length || grid[i][j] != grid[new_i][new_j])continue;

            if(detectCycle(grid,new_i,new_j,i,j,visited))return true;            
        }return false;
    }
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(!visited[i][j]){
                    if(detectCycle(grid,i,j,i,j,visited))return true;
                }
            }
        }return false;
    }
}