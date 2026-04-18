class Solution {
    private boolean colorIt(int[][] graph , int i, int[] color, int prevColor){
        if(color[i]==prevColor)return false;
        if(color[i]!=-1)return true;
        int currColor = prevColor==1?2:1;
        color[i] = currColor;
        for(int j=0 ; j<graph[i].length ; j++){
            if(!colorIt(graph,graph[i][j],color,currColor))return false;
        }return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0 ; i<graph.length ; i++){
            if(!colorIt(graph,i,color,-2))return false;
        }return true;
    }
}