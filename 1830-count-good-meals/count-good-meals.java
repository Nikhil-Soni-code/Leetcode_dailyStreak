class Solution {
    int MOD = 1000000007;
    private int twoSum(int[] arr , int target){
        HashMap<Integer,Integer> map = new HashMap();
        long ans = 0;
        for(int i=0 ; i<arr.length ; i++){
            if(map.containsKey(target-arr[i])){
                ans = (ans + map.get(target-arr[i]))%MOD;
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        return (int)ans;
    }
    public int countPairs(int[] deliciousness) {
        long ans = 0;
        for(int i=0 ; i<=21 ; i++){
            int target = 1<<i;
            ans = (ans + twoSum(deliciousness,target)) % MOD;
        }return (int)ans;
    }
}