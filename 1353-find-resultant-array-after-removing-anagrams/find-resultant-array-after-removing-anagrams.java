class Solution {
    private boolean isAnagram(String a,String b){
        if(a.length()!=b.length())return false;
        int[] hash = new int[26];
        for(int i=0;i<a.length();i++){
            hash[a.charAt(i)-97]++;
            hash[b.charAt(i)-97]--;
        }
        for(int i=0;i<26;i++){
            if(hash[i]!=0)return false;
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList();
        ans.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(isAnagram(words[i],ans.get(ans.size()-1))){

            }else{
                ans.add(words[i]);
            }
        }
        return ans;
    }
}