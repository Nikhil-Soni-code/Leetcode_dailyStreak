class Solution {
    private boolean dfs(List<List<Integer>> adj , boolean[] pathVisited , boolean[] visited,int node){
        if(pathVisited[node])return false;
        if(visited[node])return true;
        visited[node] = true;
        pathVisited[node] = true;
        for(Integer i : adj.get(node)){
            if(!dfs(adj,pathVisited,visited,i))return false;
        }
        pathVisited[node] = false;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList();
        for(int i=0 ; i<numCourses ; i++){
            adj.add(new ArrayList());
        }
        for(int i=0 ; i<prerequisites.length ; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        for(int i=0 ; i<numCourses ; i++){
            if(!visited[i]){
                if(!dfs(adj,new boolean[numCourses],visited,i))return false;

            }
        }
        return true;
    }
}