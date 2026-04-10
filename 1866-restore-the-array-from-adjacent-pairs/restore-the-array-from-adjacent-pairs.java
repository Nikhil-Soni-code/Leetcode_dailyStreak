class Solution {
    int idx=0;
    private void traverse(HashMap<Integer,List<Integer>> map,int node , int[] ans,HashSet<Integer> visited){
        if(visited.contains(node))return;
        ans[idx++] = node;
        visited.add(node);
        for(Integer key : map.get(node)){
            traverse(map,key,ans,visited);
        }
    }
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer,List<Integer>> map = new HashMap();
        HashSet<Integer> visited = new HashSet();
        for(int i=0 ; i<adjacentPairs.length ; i++){
            map.computeIfAbsent(adjacentPairs[i][0], k -> new ArrayList<>())
   .add(adjacentPairs[i][1]);
            map.computeIfAbsent(adjacentPairs[i][1], k -> new ArrayList<>())
   .add(adjacentPairs[i][0]);
        }
        int[] ans = new int[map.size()];
        for(Integer key : map.keySet()){
            if(map.get(key).size()==1){
                traverse(map,key,ans,visited);
                break;
            }
        }return ans;
    }
}