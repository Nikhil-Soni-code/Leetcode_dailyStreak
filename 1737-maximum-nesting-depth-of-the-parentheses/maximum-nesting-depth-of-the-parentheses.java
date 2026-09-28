class Solution {
    public int maxDepth(String s) {
        int brace = 0;
        int max = 0;
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i)=='(')brace++;
            else if(s.charAt(i)==')') brace--;
            max = Math.max(max,brace);
        }return max;
    }
}