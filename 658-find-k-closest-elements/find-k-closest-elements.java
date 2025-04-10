
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int first = Math.abs(a-x);
            int second = Math.abs(b-x);
            
            if(first==second){
                return a-b;
            }
            else{
                return first-second;
            }
        });
        List<Integer> ans = new ArrayList();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        for(int i=0;i<k;i++){
            ans.add(pq.poll());
        }
        Collections.sort(ans);
        return ans;
    }

}