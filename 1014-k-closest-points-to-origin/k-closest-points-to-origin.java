class Pair{
    int i;
    int j;
    public Pair(int i,int j){
        this.i = i;
        this.j = j;
    }

}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return ((b.i*b.i)+(b.j*b.j))-((a.i*a.i)+(a.j*a.j));
        });
        for(int i=0;i<points.length;i++){
            pq.add(new Pair(points[i][0],points[i][1]));
            if(pq.size()>k)pq.poll();
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while(pq.size()!=0){
            Pair pair = pq.poll();
            ans[idx++] = new int[]{pair.i,pair.j};
        }return ans;
    }
}