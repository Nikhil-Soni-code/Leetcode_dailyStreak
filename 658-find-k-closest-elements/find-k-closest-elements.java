class Pair{
    int ele;
    public Pair(int x){
        this.ele = x;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            int first = Math.abs(a.ele-x);
            int second = Math.abs(b.ele-x);
            
            if(first==second){
                return a.ele-b.ele;
            }
            else{
                return first-second;
            }
        });
        List<Integer> ans = new ArrayList();
        for(int i=0;i<arr.length;i++){
            pq.add(new Pair(arr[i]));
        }
        for(int i=0;i<k;i++){
            ans.add(pq.poll().ele);
        }
        Collections.sort(ans);
        return ans;
    }

}