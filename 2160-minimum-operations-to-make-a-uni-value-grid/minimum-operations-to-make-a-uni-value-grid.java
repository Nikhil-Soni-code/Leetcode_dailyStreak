class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] elements = new int[grid.length*grid[0].length];
        int idx = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                elements[idx++] = grid[i][j];
            }
        }
        Arrays.sort(elements);
        int opr = 0;
        int target = elements[elements.length/2];
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(Math.abs(target-grid[i][j]) % x==0){
                    opr = opr + Math.abs(target-grid[i][j])/x;
                }else{
                    return -1;
                }
            }
        }return opr;
    }
}