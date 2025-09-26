class Solution {
    private boolean dfs(List<List<Integer>> adj,int node,int[] visited,int[] pathVis)
    {
        if(visited[node]==1&&pathVis[node]==1)return true;
        if(visited[node]==1)return false;
        visited[node] = 1;
        pathVis[node] = 1;

        List<Integer> subAdj = adj.get(node);
        for(int i=0;i<subAdj.size();i++){
            if(dfs(adj,subAdj.get(i),visited,pathVis))return true;
        }
        pathVis[node] = 0;
        return false;

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj  = new ArrayList();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] visited = new int[graph.length];
        int[] pathVis = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(visited[i]==0){
                dfs(adj,i,visited,pathVis);
            }
        }
        List<Integer> ans = new ArrayList();
        for(int i=0;i<pathVis.length;i++){
            if(pathVis[i]==0)
            ans.add(i);
        }
        return ans;
    }
}