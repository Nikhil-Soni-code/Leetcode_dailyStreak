class Solution {
    private boolean find(int i,String s,HashSet<String> dict,Boolean[] dp){
        if(i==s.length()){
            return true;
        }
        if(dp[i] != null)return dp[i];
        for(int idx=i;idx<s.length();idx++){
            if(dict.contains(s.substring(i,idx+1))){
                if(find(idx+1,s,dict,dp)){

                    dp[i] = true;
                    return true;
                }
            }
        }
        dp[i] = false;
        return dp[i];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet();
        Boolean[] dp = new Boolean[s.length()+1];
        Arrays.fill(dp,null);
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        return find(0,s,set,dp);
    }
}