class Solution {
    private boolean dfs(int node,int[][] graph,int[] visited,int []pathMark,int[] ans){
        visited[node] = 1;
        pathMark[node] = 1;
        int[] list = graph[node];
        for(int i=0;i<list.length;i++){
            if(visited[list[i]]==1&&pathMark[list[i]]==1){
                return false;
            }
            if (visited[list[i]] == 0) {
                if (!dfs(list[i], graph, visited, pathMark, ans)) {
                    return false;
                }
            }
        }
        ans[node] = 1;
        pathMark[node] = 0;
        return true;


    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        int[] pathMark = new int[graph.length];
        int[] ans = new int[graph.length];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                dfs(i,graph,visited,pathMark,ans);
            }
        }
        List<Integer> finalAns = new ArrayList();
        for(int i=0;i<ans.length;i++){
            if(ans[i]==1){
                finalAns.add(i);
            }
        }
        return finalAns;


    }
}