class Pair{
    double pass;
    double total;
    public Pair(double pass,double total){
        this.pass = pass;
        this.total = total;
    }
    
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
    (a, b) -> Double.compare(
        (b.pass + 1) / (b.total + 1) - (b.pass / b.total),  // gain if extra student
        (a.pass + 1) / (a.total + 1) - (a.pass / a.total)   // compare gains
    )
);

        for(int i=0;i<classes.length;i++){
            Pair pair = new Pair(0.0+classes[i][0],0.0+classes[i][1]);
            pq.add(pair);
        }
        while(extraStudents>0){
            Pair pair = pq.poll();
            pair.pass += 1;
            pair.total += 1;
            pq.add(pair);
            extraStudents--;
        }
        double ans = 0;
        while(pq.size()!=0)
        {
            Pair pair = pq.poll();
            ans+= (pair.pass/pair.total);
        }return ans/classes.length;

    }
}