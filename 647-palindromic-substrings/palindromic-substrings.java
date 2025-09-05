class Solution {
    private int build(String s, int i) {
        if (i == s.length()) return 0;
        int count = 0;
        for (int idx = i; idx < s.length(); idx++) {
            if (isPalindrome(s.substring(i, idx + 1))) {
                count++;  // only count this palindrome
            }
        }
        // continue checking from next index
        return count + build(s, i + 1);
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
        return build(s, 0);
    }
}
