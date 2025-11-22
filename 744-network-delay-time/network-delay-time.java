class Pair{
    int target;
    int time;
    public Pair(int target,int time){
        this.target = target;
        this.time = time;
    }
}
class Network{
    int target;
    int time;
    public Network(int target,int time){
        this.target = target;
        this.time = time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        int[] dist = new int[n+1];
        PriorityQueue<Network> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new Network(k,0));
        while(!pq.isEmpty()){
            Network network = pq.poll();
            int src = network.target;
            int time = network.time;

            for(Pair pair:adj.get(src)){
                int target = pair.target;
                int totalTime = pair.time+time;
                if(dist[target]>totalTime){
                    dist[target] = totalTime;
                    pq.add(new Network(target,totalTime));
                }
            }
        }
        int minTimeToReceive = 0;
        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            minTimeToReceive = Math.max(minTimeToReceive,dist[i]);
        }return minTimeToReceive;

    }
}