class Solution {
    HashMap<String,Boolean> dp = new HashMap();
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))return true;
        if(s1.length()<=1)return false;
        if(s1.length()!=s2.length())return false;
        if(dp.containsKey(s1+"|"+s2))return dp.get(s1+"|"+s2);
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Case 1: No swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                    dp.put(s1+"|"+s2,true);
                return true;
            }

            // Case 2: Swap
            if (isScramble(s1.substring(0, i), s2.substring(n-i)) &&
                isScramble(s1.substring(i), s2.substring(0, n-i))) {
                dp.put(s1+"|"+s2,true);
                return true;
            }
        }
                    dp.put(s1+"|"+s2,false);

        return false;
    }
}