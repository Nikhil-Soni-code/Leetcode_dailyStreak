class Solution {
    private void dfs(List<List<Integer>> ans,List<Integer> subAns,int[][] graph,int node,int target){
        subAns.add(node);
        if(node==target){
            ans.add(new ArrayList(subAns));
            subAns.remove(subAns.size()-1);
            return;
        }
        int[] a = graph[node];
        for(int i=0;i<a.length;i++){
            dfs(ans,subAns,graph,a[i],target);
        }
        subAns.remove(subAns.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList();
        dfs(ans,new ArrayList(),graph,0,graph.length-1);
        return ans;
    }
}