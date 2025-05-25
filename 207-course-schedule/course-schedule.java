class Solution {
    private boolean dfs(int node,int[] visited,int[] pathVis,List<List<Integer>> adj)
    {
        visited[node] = 1;
        pathVis[node] = 1;
        List<Integer> list = adj.get(node);
        for(int i=0;i<list.size();i++){
            if(visited[list.get(i)]==1&&pathVis[list.get(i)]==1){
                return false;
            }
            if(visited[list.get(i)]==0){
                if(!dfs(list.get(i),visited,pathVis,adj))return false;
            }
        }

        pathVis[node] = 0;
        return true;
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

        for(int i=0;i<visited.length;i++){
            if(visited[i]==0&&!dfs(i,visited,pathVis,adj)){
                return false;
            }
        }
        return true;
    }
}