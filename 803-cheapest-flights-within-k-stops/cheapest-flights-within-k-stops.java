class Pair{
    int to;
    int price;
    public Pair(int to,int price){
        this.to = to;
        this.price = price;
    }
}

class Trip{
    int price;
    int place;
    int stops;
    public Trip(int place,int price,int stops){
        this.price = price;
        this.place = place;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0;i<flights.length;i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            adj.get(from).add(new Pair(to,price));
        }

        Queue<Trip> pq = new LinkedList<Trip>();
        int cost[] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);

        pq.add(new Trip(src,0,0));
        cost[src] = 0;

        while(!pq.isEmpty()){
            Trip trip = pq.poll();
            int price = trip.price;
            int place = trip.place;
            int stops = trip.stops;

            if(stops > k) continue;

            for(Pair pair : adj.get(place)){
                int end = pair.to;
                int newPrice = pair.price + price;

                // update cost only if cheaper
                if(newPrice < cost[end]){
                    cost[end] = newPrice;
                pq.add(new Trip(end, newPrice, stops + 1));

                }

                // always explore next node if stops <= k
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
