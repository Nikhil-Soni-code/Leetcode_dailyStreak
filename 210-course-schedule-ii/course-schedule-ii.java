class Solution {
    int idx = 0;
    private boolean isCycle(List<List<Integer>> adj,int[] visited,int[] pathVis,int node)
    {
        if(visited[node]==1&&pathVis[node]==1){
            return true;
        }
        if(visited[node]==1)return false;
        visited[node] = 1;
        pathVis[node] = 1;
        List<Integer> subAdj = adj.get(node);
        for(int i=0;i<subAdj.size();i++){
            if(isCycle(adj,visited,pathVis,subAdj.get(i)))return true;
        }
        pathVis[node] = 0;

        return false;
    }
    private void topoSort(List<List<Integer>> adj,int node,int[] visited,int[] ans){
        if(visited[node]==1)return;
        visited[node] = 1;
        List<Integer> subAdj = adj.get(node);
        for(int i=0;i<subAdj.size();i++){
            topoSort(adj,subAdj.get(i),visited,ans);
        }
        ans[idx--] = node;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        int[] pathVis = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(isCycle(adj,visited,pathVis,i))return new int[]{};
            }
        }
        Arrays.fill(visited,0);
        Arrays.fill(pathVis,0);
        int[] ans = new int[numCourses];
        idx = ans.length-1;
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                topoSort(adj,i,visited,ans);
            }
        }
        return ans;

        
    }
}