class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2];
        HashSet<Integer> set = new HashSet();
        for(int i=0;i<n;i++){
            for(int j=0;j<grid[0].length;j++){
                if(set.size()!=0&&set.contains(grid[i][j])){
                    ans[0] = grid[i][j];
                }else{
                    set.add(grid[i][j]);
                }
            }
        }
        for(int i=1;i<=n*n;i++){
            if(!set.contains(i)){
                ans[1] = i;
                return ans;
            }
        }
        return new int[2];
    }
}