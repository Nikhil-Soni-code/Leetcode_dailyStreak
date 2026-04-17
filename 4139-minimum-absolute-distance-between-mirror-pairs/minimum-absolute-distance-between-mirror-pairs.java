class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int minAbs = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                minAbs = Math.min(minAbs,Math.abs(i-map.get(nums[i])));
            }
            map.put(reverse(nums[i]),i);
        }
        return (minAbs==Integer.MAX_VALUE)?-1:minAbs;
    }
    private int reverse(int n){
        int rev = 0;
        while(n!=0){
            rev = rev*10+n%10;
            n = n/10;
        }
        return rev;
    }
}