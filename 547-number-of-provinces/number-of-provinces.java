class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length+1];
        int count = 0;
        for(int i=1;i<visited.length;i++){
            if(visited[i]==0){
                count++;
                visited[i] = 1;
                dfs(i,visited,isConnected);
            }
        }
        return count;
    }
    private void dfs(int node,int[] visited,int[][] isConnected){
        int[] a = isConnected[node-1];
        for(int i=0;i<a.length;i++){
            if(a[i]==1&&visited[i+1]==0){
                visited[i+1] = 1;
                dfs(i+1,visited,isConnected);
            }
        }

    }
}