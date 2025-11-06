class Solution {
    private boolean isEqual(int[] hash,int[] targetHash){
        for(int i=0;i<26;i++){
            if(hash[i]!=targetHash[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList();
        if(s.length()<p.length())return ans;

        int i=0;
        int[] hash = new int[26];
        int[] targetHash = new int[26];
        for(i=0;i<p.length();i++){
            targetHash[p.charAt(i)-'a']++;
            hash[s.charAt(i)-'a']++;
        }
        if(isEqual(hash,targetHash))ans.add(0);
        int j=0;
        while(i<s.length()){
            hash[s.charAt(i)-'a']++;
            hash[s.charAt(j)-'a']--;
            j++;
            if(isEqual(hash,targetHash))ans.add(j);
            i++;

        }
        return ans;
    }
}