class Solution {
    private boolean find(List<List<Integer>> adj,int destination,int node,int[] visited){
        if(node==destination)return true;
        if(visited[node]==1)return false;
        visited[node] = 1;
        List<Integer> subAdj = adj.get(node);
        for(int i=0;i<subAdj.size();i++){
            if(find(adj,destination,subAdj.get(i),visited))return true;
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] visited = new int[n];
        return find(adj,destination,source,visited);

    }
}