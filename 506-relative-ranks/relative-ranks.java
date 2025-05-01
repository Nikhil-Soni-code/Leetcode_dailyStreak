class Pair{
    int ele;
    int idx;
    public Pair(int ele,int idx){
        this.ele = ele;
        this.idx = idx;
    }
}
class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.ele-a.ele);
        for(int i=0;i<score.length;i++){
            pq.add(new Pair(score[i],i));
        }
        String[] ans = new String[score.length];
        if(pq.size()!=0){
            Pair pair = pq.poll();
            ans[pair.idx] = "Gold Medal";
        }
                if(pq.size()!=0){
            Pair pair = pq.poll();
            ans[pair.idx] = "Silver Medal";
        }
                if(pq.size()!=0){
            Pair pair = pq.poll();
            ans[pair.idx] = "Bronze Medal";
        }
        int n = 4;
        while(pq.size()!=0){
            Pair pair = pq.poll();
            ans[pair.idx] = ""+n;
            n++;
        }
        return ans;
    }
}