class Solution {
    private void dfs(int node,List<List<Integer>> adjList,int[] visited){
        visited[node] = 1;
        List<Integer> subAdj = adjList.get(node);
        for(int i=0;i<subAdj.size();i++){
            if(visited[subAdj.get(i)]==0){
                dfs(subAdj.get(i),adjList,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList();
        for(int i=0;i<isConnected.length+1;i++){
            adjList.add(new ArrayList());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    adjList.get(i+1).add(j+1);
                    adjList.get(j+1).add(i+1);
                }
            }
        }
        int[] visited = new int[isConnected.length+1];
        int count = 0;
        for(int i=1;i<visited.length;i++){
            if(visited[i]==0){
                count++;
                dfs(i,adjList,visited);
            }
        }return count;

    }
}