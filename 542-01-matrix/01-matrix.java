class Pair{
    int i;
    int j;
    int dis;
    public Pair(int i,int j,int dis){
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        Queue<Pair> queue = new LinkedList();
        for(int[]a:dist){
            Arrays.fill(a,-1);
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    queue.add(new Pair(i,j,0));
                    dist[i][j] = 0;
                }
            }
        }
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int i = pair.i;
            int j = pair.j;
            int dis = pair.dis;
            if(i+1<mat.length&&dist[i+1][j]==-1){
                queue.add(new Pair(i+1,j,dis+1));
                dist[i+1][j] = dis+1;
            }
            if(j+1<mat[0].length&&dist[i][j+1]==-1){
                queue.add(new Pair(i,j+1,dis+1));
                dist[i][j+1] = dis+1;
            }
            if(i-1>=0&&dist[i-1][j]==-1){
                queue.add(new Pair(i-1,j,dis+1));
                dist[i-1][j] = dis+1;
            }
            if(j-1>=0&&dist[i][j-1]==-1){
                queue.add(new Pair(i,j-1,dis+1));
                dist[i][j-1] = dis+1;
            }
        }
        return dist;

        
    }
}