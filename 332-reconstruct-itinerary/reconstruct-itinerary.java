class Solution {
    private void dfs(HashMap<String,PriorityQueue<String>> map,String s,List<String> ans){
        PriorityQueue<String> pq= map.get(s);
        while(pq!=null&&!pq.isEmpty()){
            dfs(map,pq.poll(),ans);
        }
        ans.add(0,s);

    }
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> t : tickets) {
            map.putIfAbsent(t.get(0), new PriorityQueue<>());
            map.get(t.get(0)).add(t.get(1));
        }

        dfs(map,"JFK",ans);
        return ans;
    }
}