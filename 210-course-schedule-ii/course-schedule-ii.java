class Solution {
    private boolean check(List<List<Integer>> adj , int node , boolean[] visited , boolean[] pathVisited){
        if(pathVisited[node])return true;
        if(visited[node])return false;
        visited[node] = true;
        pathVisited[node] = true;
        for(Integer i : adj.get(node)){
            if(check(adj,i,visited,pathVisited))return true;
        }

        pathVisited[node] = false;
        return false;
    }
    int idx = 0;
    private void topoSort(List<List<Integer>> adj , int node , boolean[] visited,int[] ans){
        if(visited[node])return;
        visited[node] = true;
        for(Integer i : adj.get(node)){
            topoSort(adj,i,visited,ans);
        }
        ans[idx--] = node;


    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList();
        for(int i=0 ; i<numCourses ; i++){
            adj.add(new ArrayList());
        }
        for(int[] a : prerequisites){
            adj.get(a[1]).add(a[0]);
        }
        boolean[] visited = new boolean[numCourses];
        Arrays.fill(visited,false);
        //cycle detection
        for(int i=0 ; i<numCourses ; i++){
            if(check(adj,i,visited,new boolean[numCourses]))return new int[]{};
        }
        System.out.println("yo");
        //topoSort
        int[] ans = new int[numCourses];
        idx = numCourses-1;
        Arrays.fill(visited,false);
        for(int i=0 ; i<numCourses ; i++){
            if(!visited[i])topoSort(adj,i,visited,ans);
        }return ans;
        
        

    }
}