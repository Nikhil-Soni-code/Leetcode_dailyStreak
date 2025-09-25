class Solution {
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
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
                if(isCycle(adj,visited,pathVis,i))return false;
            }
        }
        return true;
        
    }
}