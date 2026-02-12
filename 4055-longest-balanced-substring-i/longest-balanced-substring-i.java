class Solution {
    private boolean allEqual(int[] hash){
        int count = 0;
        for(int i=0;i<26;i++){
            if(count==0 && hash[i]!=0){
                count = hash[i];
            }
            if(hash[i]!=0 && count!=hash[i])return false;
        }
        return true;
    }
    public int longestBalanced(String s) {
        int ans = 0;
        for(int i=0 ; i<s.length() ; i++){
            int[] hash = new int[26];
            for(int j=i ; j<s.length() ; j++){
                hash[s.charAt(j)-'a']++;
                if(allEqual(hash)){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}