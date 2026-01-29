class Solution {
    private boolean match(String s, String p, int i, int j) {
        if (j >= p.length()) {
            return i == s.length();
        }

        if (j < p.length() - 1 && p.charAt(j + 1) == '*'
                && (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))) {

            boolean take = match(s, p, i + 1, j);
            boolean notTake = match(s, p, i, j + 2);
            return take || notTake;
        }

        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            return match(s, p, i, j + 2);
        }

        if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            return match(s, p, i + 1, j + 1);
        }

        return false;
    }

    public boolean isMatch(String s, String p) {
        return match(s, p, 0, 0);
    }
}
