class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList();
        int freshOrange = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                copy[i][j] = grid[i][j];
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshOrange++;
                }
            }
        }
        int minutes = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int idx=0;idx<size;idx++){
                int[] a = queue.poll();
                int i = a[0];
                int j = a[1];

                if(i-1>=0&&copy[i-1][j]==1){
                    copy[i-1][j]=2;
                    queue.add(new int[]{i-1,j});
                    freshOrange--;

                }
                
                if(j-1>=0&&copy[i][j-1]==1){
                    copy[i][j-1]=2;
                    queue.add(new int[]{i,j-1});
                freshOrange--;

                }
                
                if(i+1<copy.length&&copy[i+1][j]==1){
                    copy[i+1][j]=2;
                    queue.add(new int[]{i+1,j});
                freshOrange--;

                }
                if(j+1<copy[0].length&&copy[i][j+1]==1){
                    copy[i][j+1]=2;
                    queue.add(new int[]{i,j+1});
                freshOrange--;

                }

            }
            minutes++;
        }
        if(freshOrange==0){
            return (minutes==-1)?0:minutes;
        }
        return -1;




    }
}