class Solution {
    public int minimumArea(int[][] grid) {
        int rowStart = Integer.MAX_VALUE;
        int rowEnd = -1;

        int colStart = Integer.MAX_VALUE;
        int colEnd = -1;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    rowStart = Math.min(rowStart,j);
                    rowEnd = Math.max(rowEnd,j);

                    colStart = Math.min(colStart,i);
                    colEnd = Math.max(colEnd,i);
                }
            }

        }
        if(rowStart==Integer.MAX_VALUE)return 0;
        int length = colEnd-colStart+1;
        int breadth =  rowEnd-rowStart+1;
        return length*breadth;


    }
}