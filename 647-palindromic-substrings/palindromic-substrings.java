class Solution {
    private int build(String s, int i,int[] dp) {
        if (i == s.length()) return 0;
        int count = 0;
        if(dp[i]!=-1)return dp[i];
        for (int idx = i; idx < s.length(); idx++) {
            if (isPalindrome(s.substring(i, idx + 1))) {
                count++;  // only count this palindrome
            }
        }
        // continue checking from next index
        dp[i] = count + build(s, i + 1,dp);
        return dp[i];
    }

    private boolean isPalindrome(String s) {
        int beg = 0, end = s.length() - 1;
        while (beg < end) {
            if (s.charAt(beg) != s.charAt(end)) return false;
            beg++;
            end--;
        }
        return true;
    }

    public int countSubstrings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return build(s, 0,dp);
    }
}
