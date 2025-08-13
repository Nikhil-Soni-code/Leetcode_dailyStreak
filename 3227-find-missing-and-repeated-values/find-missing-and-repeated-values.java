class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] a = new int[2];
        int[] pos = new int[grid.length*grid.length];
        Arrays.fill(pos,-1);
        int n = grid.length;
        int reqSum = (n*n)*(n*n+1)/2;
        int actualSum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                int correct = grid[i][j]-1;
                if(pos[correct]!=-1){
                    a[0] = grid[i][j];
                }
                pos[correct] = grid[i][j];
                actualSum+=grid[i][j];
            }
        }
        a[1] = reqSum-(actualSum-a[0]);
        return a;

    }
}