class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        for(Character key:map.keySet()){
            pq.add(map.get(key));
        }
        int ans = 0;
        while(!pq.isEmpty()){
            List<Integer> list = new ArrayList();
            for(int i=0;i<n+1;i++){
                if(!pq.isEmpty()){
                    int top = pq.poll()-1;
                    list.add(top);
                }
            }
            for(int i=0;i<list.size();i++){
                if(list.get(i)!=0)pq.add(list.get(i));
            }
            if(pq.isEmpty()){
                ans+=list.size();
            }
            else{
                ans+=n+1;
            }
        }
        return ans;

    }
}