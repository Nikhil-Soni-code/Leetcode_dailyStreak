class Solution {
    private void findAllPossibleSentences(List<String> ans,String target,String subAns,int idx,HashSet<String> set){
        if(idx==target.length()){
            ans.add(subAns.substring(1));
            return;
        }
        for(int i=idx;i<target.length();i++){
            String subStr = target.substring(idx,i+1);
            if(set.contains(subStr)){
                findAllPossibleSentences(ans,target,subAns+" "+subStr,i+1,set);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList();
        HashSet<String> set = new HashSet();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        findAllPossibleSentences(ans,s,"",0,set);
        return ans;


    }
}