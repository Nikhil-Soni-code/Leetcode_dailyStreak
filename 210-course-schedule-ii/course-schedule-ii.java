class Solution {
    private boolean dfs(int node,Stack<Integer> stack,int[] visited,int[] pathVisited,List<List<Integer>> adj){

        visited[node] = 1;
        pathVisited[node] = 1;
        List<Integer> list = adj.get(node);
        for(int i=0;i<list.size();i++){
            if(visited[list.get(i)]==1&&pathVisited[list.get(i)]==1)return false;
            if(visited[list.get(i)]==0&&!dfs(list.get(i),stack,visited,pathVisited,adj)){
                return false;
            }
        }
        stack.push(node);
        pathVisited[node] = 0;
        return true;
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
        int[] pathVisited = new int[numCourses];
        Stack<Integer> stack = new Stack();
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                if(!dfs(i,stack,visited,pathVisited,adj)){
                    return new int[]{};
                }
            }
        }
        int[] ans = new int[stack.size()];
        int idx = 0;
        while(!stack.empty()){
            ans[idx++] = stack.pop();
        }
        return ans;

    }
}