class Solution {
    public int longestValidParentheses(String s) {
        int left = 0,right = 0,max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')left++;
            if(s.charAt(i)==')')right++;
            if(right==left)max = Math.max(max,left*2);
            if(right>left){
                right=0;
                left=0;
            }
        }
        left = 0;right = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')')right++;
            if(s.charAt(i)=='(')left++;
            if(right==left)max = Math.max(max,left*2);
            if(left>right){
                left=0;
                right = 0;
            }
        }
        return max;
    }
}