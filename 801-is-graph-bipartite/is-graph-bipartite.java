class Solution {
    private boolean check(List<List<Integer>> adj,int prev,int node,int[] visited){

        if(visited[node]!=0){
            if(visited[node]==prev){
                return false;
            }return true;
        }
        int color = prev==2?1:2;
        visited[node] = color;
        List<Integer> subAdj = adj.get(node);
        for(int i=0;i<subAdj.size();i++){
            if(!check(adj,color,subAdj.get(i),visited))return false;
        }
        return true;

    }
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList());
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] visited = new int[graph.length];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                if(!check(adj,-1,i,visited))return false;
            }
        }
        return true;
    }
}