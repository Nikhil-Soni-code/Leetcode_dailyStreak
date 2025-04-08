class Pair{
    int value;
    int count;
    public Pair(int value,int count){
        this.value = value;
        this.count = count;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Pair []arr = new Pair[map.size()];
        int idx = 0;
        for(Integer i:map.keySet()){
            arr[idx++] = new Pair(i,map.get(i));
        }
        Arrays.sort(arr,(a,b)-> {
            if(a.count==b.count) return b.value-a.value;
            else return a.count-b.count;
            
        });
        idx = 0;
        for(int i=0;i<arr.length;i++){
            int count = arr[i].count;
            int value = arr[i].value;
            for(int j=0;j<count;j++){
                nums[idx++] = value;
            }
        }
        return nums;
    }
}