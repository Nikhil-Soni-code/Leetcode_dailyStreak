class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] copy = new int[mat.length][mat[0].length];
        int[][] ans = new int[mat.length][mat[0].length];

        Queue<int[]> queue = new LinkedList();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                copy[i][j] = mat[i][j];
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j,0});
                    ans[i][j] = 0;
                }else{
                    ans[i][j] = -1;
                }
            }
        }
        
        //bfs
        while(!queue.isEmpty()){
            int[] a = queue.poll();
            int i = a[0];
            int j = a[1];
            int distance = a[2];
            if(i-1>=0&&copy[i-1][j]==1&&ans[i-1][j]==-1){
                ans[i-1][j] = distance+1;
                queue.add(new int[]{i-1,j,distance+1});
            }
            if(j-1>=0&&copy[i][j-1]==1&&ans[i][j-1]==-1){
                ans[i][j-1] = distance+1;
                queue.add(new int[]{i,j-1,distance+1});
            }
            if(i+1<copy.length&&copy[i+1][j]==1&&ans[i+1][j]==-1){
                ans[i+1][j] = distance+1;
                queue.add(new int[]{i+1,j,distance+1});
            }
            if(j+1<copy[0].length&&copy[i][j+1]==1&&ans[i][j+1]==-1){
                ans[i][j+1] = distance+1;
                queue.add(new int[]{i,j+1,distance+1});
            }
        }
        return ans;
         
    }
}