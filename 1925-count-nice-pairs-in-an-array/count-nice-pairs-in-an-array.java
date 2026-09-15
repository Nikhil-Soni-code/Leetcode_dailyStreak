class Solution {
    private int rev(int n){
        int rev = 0;
        while(n!=0){
            rev = rev*10 + n%10;
            n/=10;
        }return rev;
    }
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        long count = 0;
        int MOD = 1000000007;
        for(int i=0 ; i<nums.length ; i++){
            int reverse = rev(nums[i]);
            count = (count + map.getOrDefault(nums[i]-reverse,0))%MOD;
            map.put(nums[i]-reverse,map.getOrDefault(nums[i]-reverse,0)+1);
        }return (int)count;
    }
}