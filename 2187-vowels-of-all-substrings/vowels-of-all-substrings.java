class Solution {
    public long countVowels(String word) {
        HashSet<Character> v = new HashSet<>();
        v.add('a'); v.add('e'); v.add('i'); v.add('o'); v.add('u');

        long ans = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            if (v.contains(word.charAt(i))) {
                ans += (long)(i+1)*(n-i);
            }
        }
        return ans;
    }
}
