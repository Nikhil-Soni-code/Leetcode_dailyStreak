class Solution {
    private void shift(int[][] grid){
        int lastElement = grid[grid.length-1][grid[0].length-1];
        for(int i=grid.length-1 ; i>=0 ; i--){
            for(int j=grid[0].length-1 ; j>=0 ; j--){
                if(i==0 && j==0){
                    grid[i][j] = lastElement;
                }
                else if(j==0){
                    grid[i][j] = grid[i-1][grid[0].length-1];
                }
                else{
                    grid[i][j] = grid[i][j-1];
                }
            }
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        k = k % (grid.length*grid[0].length);
        for(int i=0 ; i<k ; i++){
            shift(grid);
        }
        List<List<Integer>> ans = new ArrayList();
        for(int[] row : grid){
            List<Integer> subAns = new ArrayList();
            for(int i=0 ; i<row.length ; i++){
                subAns.add(row[i]);
            }
            ans.add(new ArrayList(subAns));
        }
        return ans;
    }

}