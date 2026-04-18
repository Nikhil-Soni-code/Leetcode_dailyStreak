class Solution {
    private boolean find(List<List<Integer>> adj , Boolean[] memo , int node,boolean[] visited){
        if(memo[node]!=null)return memo[node];

        if(adj.get(node).size()==0){
            memo[node] = true;
            return true;
        }
        if(visited[node])return false;
        visited[node] = true;
        boolean isEventual = true;
        for(Integer num : adj.get(node)){
            if(!find(adj,memo,num,visited)){
                isEventual = false;
            }
        }
        if(isEventual){
            memo[node] = true;
            return true;
        }
        else {
            memo[node] = false;
            return false;
        } 
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList();
        List<List<Integer>> adj = new ArrayList();
        for(int i=0 ; i<graph.length ; i++){
            adj.add(new ArrayList());
        }
        for(int i=0 ; i<graph.length ; i++){
            for(Integer j:graph[i]){
                adj.get(i).add(j);
            }
        }
        Boolean[] memo = new Boolean[graph.length];
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(visited,false);
        Arrays.fill(memo,null);
        for(int i=0 ; i<graph.length ; i++){
            if(!visited[i]){
                find(adj,memo,i,visited);
            }
        }
        for(int i=0 ; i<graph.length ; i++){
            if(memo[i])ans.add(i);
        }return ans;
    }
}