class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        int count = 0;
        for(Character ch:set){
            HashSet<Character> seqSet = new HashSet();
            int beg = -1, end = -1;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==ch){
                    beg = i;
                    break;
                }
            }
            for(int i=s.length()-1;i>=0;i--){
                if(s.charAt(i)==ch){
                    end = i;
                    break;
                }
            }
            if(beg!=-1&&end!=-1){
                for(int i=beg+1;i<end;i++){
                    seqSet.add(s.charAt(i));
                }
            }
            count+=seqSet.size();
        }return count;
    }
}