class Pair{
    int i;
    int j;
    int dist;
    public Pair(int i,int j,int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> queue = new LinkedList();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        
        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int i = pair.i;
            int j = pair.j;
            int dist = pair.dist;

            mat[i][j] = dist;
            if(i>0 && mat[i-1][j] == 1 && !visited[i-1][j]){
                queue.add(new Pair(i-1,j,dist+1));
                visited[i-1][j] = true;
            }
            if(j>0 && mat[i][j-1] == 1 && !visited[i][j-1]){
                queue.add(new Pair(i,j-1,dist+1));
                visited[i][j-1] = true;
            }         
            if(i<mat.length-1 && mat[i+1][j] == 1 && !visited[i+1][j]){
                queue.add(new Pair(i+1,j,dist+1));
                visited[i+1][j] = true;
            }           
            if(j<mat[0].length-1 && mat[i][j+1] == 1 && !visited[i][j+1]){
                queue.add(new Pair(i,j+1,dist+1));
                visited[i][j+1] = true;
            }
        }
        return mat;
    }
}