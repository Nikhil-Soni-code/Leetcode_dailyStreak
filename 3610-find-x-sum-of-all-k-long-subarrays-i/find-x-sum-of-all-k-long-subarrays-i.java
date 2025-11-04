class Pair{
    int val;
    int occur;
    public Pair(int val,int occur){
        this.val = val;
        this.occur = occur;
    }
}
class Solution {
    private int x_sum(HashMap<Integer,Integer> map,int x){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(b.occur==a.occur){
                return b.val-a.val;
            }else{
                return b.occur-a.occur;
            }
        });
        for(Integer key:map.keySet()){
            pq.add(new Pair((int)key,(int)map.get(key)));
        }
        int sum = 0;
        while(x!=0&&!pq.isEmpty()){
            Pair pair = pq.poll();
            sum+=(pair.val*pair.occur);
            x--;
        }
        return sum;


    }
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans = new int[nums.length-k+1];
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        ans[0] = x_sum(map,x);
        int j=k,i=0;
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            map.put(nums[i],map.get(nums[i])-1);
            if(map.get(nums[i])==0)map.remove(nums[i]);
            i++;
            ans[i] = x_sum(map,x);
            j++;
        }
        return ans;
    }
}