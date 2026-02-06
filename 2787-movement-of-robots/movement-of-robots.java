class Solution {
    int MOD = 1000000007;

    public int sumDistance(int[] nums, String s, int d) {

        int n = nums.length;
        long[] pos = new long[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                pos[i] = (long) nums[i] + d;
            } else {
                pos[i] = (long) nums[i] - d;
            }
        }

        Arrays.sort(pos);

        long sum = 0;
        long prefix = 0;

        for (int i = 0; i < n; i++) {
            sum = (sum + pos[i] * i - prefix) % MOD;
            prefix = (prefix + pos[i]) % MOD;
        }

        return (int)sum;
    }
}
