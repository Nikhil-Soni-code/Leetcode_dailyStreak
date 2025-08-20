class Solution {
    private boolean equal(int[] hash,int[] targetHash){
        for(int i=0;i<26;i++){
            if(targetHash[i]!=hash[i])return false;
        }return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int targetHash[] = new int[26];
        for(int i=0;i<s1.length();i++){
            targetHash[s1.charAt(i)-'a']++;
        }
        int[] hash = new int[26];
        for(int i=0;i<s1.length();i++){
            hash[s2.charAt(i)-'a']++;
        }
        if(equal(hash,targetHash))return true;
        int i=0,j=s1.length();
        while(j<s2.length()){
            hash[s2.charAt(i++)-'a']--;
            hash[s2.charAt(j++)-'a']++;
            if(equal(hash,targetHash))return true;
        }return false;

    }
}