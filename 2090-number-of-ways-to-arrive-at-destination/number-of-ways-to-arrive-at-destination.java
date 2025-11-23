class Pair{
    int place;
    int time;
    public Pair(int place,int time){
        this.place = place;
        this.time = time;
    }
}
class Trip{
    int place;
    long time;
    public Trip(int place,long time){
        this.place = place;
        this.time = time;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<roads.length;i++){
            int start = roads[i][0];
            int end = roads[i][1];
            int time = roads[i][2];

            adj.get(start).add(new Pair(end,time));
            adj.get(end).add(new Pair(start,time));

        }
        long[] time = new long[n];
        Arrays.fill(time,Long.MAX_VALUE);
        int[] ways = new int[n];
        Arrays.fill(ways,0);
        time[0] = 0;
        ways[0] = 1;

        PriorityQueue<Trip> pq = new PriorityQueue<>((a,b)-> Long.compare(a.time,b.time));
        pq.add(new Trip(0,0));
        while(!pq.isEmpty()){
            Trip trip = pq.poll();
            int place = trip.place;
            long oldTime = trip.time;
            if(oldTime > time[place])continue;
            for(Pair p:adj.get(place)){
                int newPlace = p.place;
                long totalTime = (oldTime + p.time);
                if(totalTime<time[newPlace]){
                    time[newPlace] = totalTime;
                    ways[newPlace] = ways[place];
                    pq.add(new Trip(newPlace,totalTime));
                }
                else if(totalTime == time[newPlace]){
                    ways[newPlace] = (int)((long)ways[place]+ways[newPlace])% 1000000007;
                    // pq.add(new Trip(newPlace,totalTime));

                }

            }
        }
        return ways[n-1] % 1000000007;

    }
}