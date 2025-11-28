class Solution {
    public String decodeAtIndex(String s, int k) {

        long size = 0;                         // must be long
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size++;
            }
        }

        long K = k;                            // work with long

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            K %= size;                         // safe now

            if (K == 0 && !Character.isDigit(c)) {
                return "" + c;
            }

            if (Character.isDigit(c)) {
                size /= (c - '0');
            } else {
                size--;
            }
        }

        return "" + s.charAt(0);
    }
}
