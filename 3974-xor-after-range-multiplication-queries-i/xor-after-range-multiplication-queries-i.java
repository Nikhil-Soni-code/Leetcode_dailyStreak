class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        for(int i=0 ; i<queries.length ; i++){
            int idx = queries[i][0];
            int limit = queries[i][1];
            int k = queries[i][2];
            int mul = queries[i][3];
            for(int j=idx ; j<=limit ; j+=k){
                nums[j] = (int)(((long)nums[j]*mul) % MOD);
            }
        }
        int xor = 0;
        for(int i=0 ; i<nums.length ; i++){
            xor ^= nums[i];
        }return xor;
    }
}