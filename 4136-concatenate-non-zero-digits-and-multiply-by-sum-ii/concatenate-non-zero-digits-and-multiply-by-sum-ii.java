class Solution {
    static final long MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        long[] pro = new long[s.length()];
        int[] sum = new int[s.length()];
        int[] len = new int[s.length()];

        long p = 0;
        int a = 0;
        int digits = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c != '0') {
                p = (p * 10 + (c - '0')) % MOD;
                a += (c - '0');
                digits++;
            }

            pro[i] = p;
            sum[i] = a;
            len[i] = digits;
        }

        // Precompute powers of 10 mod MOD
        long[] pow10 = new long[s.length() + 1];
        pow10[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            pow10[i] = (pow10[i-1] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l == 0) {
                long x = pro[r];
                long sm = sum[r];
                ans[i] = (int)((x * sm) % MOD);
            } else {
                int lenRange = len[r] - len[l-1];

                long x = (pro[r] - (pro[l-1] * pow10[lenRange]) % MOD + MOD) % MOD;
                long sm = sum[r] - sum[l-1];

                ans[i] = (int)((x * sm) % MOD);
            }
        }

        return ans;
    }
}
