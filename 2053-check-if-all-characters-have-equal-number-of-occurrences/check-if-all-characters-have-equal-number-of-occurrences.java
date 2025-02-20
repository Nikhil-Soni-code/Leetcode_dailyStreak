class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[]hash = new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-97]++;
        }
        int occur=0;
        for(int i=0;i<26;i++){
            if(hash[i]!=0&&occur==0){
                occur = hash[i];
            }
            if(hash[i]!=0&&hash[i]!=occur){
                return false;
            }
        }
        return true;
    }
}