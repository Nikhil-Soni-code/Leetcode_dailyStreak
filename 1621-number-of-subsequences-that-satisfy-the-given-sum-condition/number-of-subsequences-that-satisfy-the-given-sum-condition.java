class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int MOD = 1000000007;
        int n = nums.length;
        long[] pow = new long[n];
        pow[0] = 1;

        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }
        int i=0 , j=nums.length-1;

        long ans = 0;
        while(i<=j){
            if(nums[i]+nums[j]>target){
                j--;
            }else{
                ans = (ans + pow[j-i]) % MOD;
                i++;
            }
        }return (int)ans;
    }
}