class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,ans=0;
        int maxOcc = 0;
        int[] hash = new int[26];
        while(j<s.length()){
            hash[s.charAt(j)-'A']++;
            maxOcc = Math.max(maxOcc,hash[s.charAt(j)-'A']);
                while(j-i+1-maxOcc>k){
                    hash[s.charAt(i)-'A']--;
                    maxOcc = 0;
                    for(int idx=0;idx<26;idx++){
                            maxOcc = Math.max(maxOcc,hash[idx]);
                    }
                    i++;
                }
            ans = Math.max(ans,j-i+1);
            j++;
        }
return ans;

    }
}