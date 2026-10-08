class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder subAns = new StringBuilder();
        int brace = 0;
        for(int i=0 ; i<s.length() ; i++){
            subAns.append(s.charAt(i));
            if(s.charAt(i)=='(')brace++;
            else brace--;
            if(brace==0){
                brace=0;
                ans.append(subAns.substring(1,subAns.length()-1));
                subAns = new StringBuilder();
            }
        }return ans.toString();
    }
}