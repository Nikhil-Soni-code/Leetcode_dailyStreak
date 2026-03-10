class Solution {
    private void dfs(List<List<Integer>> adj , int node , boolean[] visited , int[] nodes , int[] edge)
    {
        if(visited[node])return;
        visited[node] = true;
        nodes[0]++;
        edge[0] += adj.get(node).size();
        for(Integer vertex : adj.get(node)){
            dfs(adj,vertex,visited,nodes,edge);
        }

    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList();
        for(int i=0 ; i<n ; i++){
            adj.add(new ArrayList());
        }
        for(int i=0 ; i<edges.length ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        int count = 0;
        for(int i=0 ; i<n ; i++){
            if(!visited[i]){
                int[] nodes = new int[1];
                int[] edge = new int[1];
                dfs(adj,i,visited,nodes,edge);
                if((nodes[0]*(nodes[0]-1)) == edge[0])count++;
            }
        }
        return count;
    }
}