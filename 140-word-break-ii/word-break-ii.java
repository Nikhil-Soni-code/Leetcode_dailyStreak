class Solution {
    private void allPossibleSentence(List<String> ans,String subAns,String s,int i,HashSet<String> dict){
        if(i==s.length()){
            ans.add(subAns.substring(1));
            return;
        }
        for(int idx=i;idx<s.length();idx++){
            if(dict.contains(s.substring(i,idx+1))){
                allPossibleSentence(ans,subAns+" "+s.substring(i,idx+1),s,idx+1,dict);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList();
        HashSet<String> dict = new HashSet();
        for(String str:wordDict){
            dict.add(str);
        }
        allPossibleSentence(ans,"",s,0,dict);
        return ans;
    }
}