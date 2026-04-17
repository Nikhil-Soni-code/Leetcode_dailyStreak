class Solution {
    public String greatestLetter(String s) {
        char ans = ' ';
        HashSet<Character> set = new HashSet();
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i) >= 65 && s.charAt(i) < 97){
                if(set.contains(Character.toLowerCase(s.charAt(i)))){
                    if(ans<s.charAt(i))ans = s.charAt(i);
                }
            }
            else if(s.charAt(i)>=97){
                if(set.contains(Character.toUpperCase(s.charAt(i)))){
                    if(ans<Character.toUpperCase(s.charAt(i)))ans = Character.toUpperCase(s.charAt(i));
                }
            }
            set.add(s.charAt(i));
        }
        if(ans==' ')return "";
        return ans+"";
    }
}