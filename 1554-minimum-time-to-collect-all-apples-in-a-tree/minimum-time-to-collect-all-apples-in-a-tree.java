class Solution {
    private int dfs(List<List<Integer>> list,int node,int parent,List<Boolean> hasApple){
        int time = 0;
        for(int child:list.get(node)){
            if(parent==child)continue;
            
            int childTime = dfs(list,child,node,hasApple);
            if(childTime>0)time+=childTime+2;
            else if(hasApple.get(child))time+=2;
        }return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> list = new ArrayList();
        for(int i=0;i<n;i++)list.add(new ArrayList());
        for(int[]edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        return dfs(list,0,-1,hasApple);
    }
}