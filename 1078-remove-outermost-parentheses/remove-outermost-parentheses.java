class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sbr = new StringBuilder();
        int i=0;
        int brace = 0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='('){
                brace++;
            }
            else{
                brace--;
            }
            if(brace==0){
                sbr.append(s.substring(i+1,j));
                i=j+1;
            }
        }
        return sbr.toString();
    }
}