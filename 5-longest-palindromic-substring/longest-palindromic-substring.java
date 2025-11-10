class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 1;
        String maxString = ""+s.charAt(0);
        for(int i=1;i<s.length();i++){
            int left = i-1;
            int right = i+1;
            int oddLengthCount = 1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                oddLengthCount+=2;
                left--;right++;
            }
            if(maxLength<oddLengthCount){
                maxLength = oddLengthCount;
                maxString = s.substring(left+1,right);
            }
            left = i-1;
            right = i;
        
            int evenLengthCount = 0;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                evenLengthCount+=2;
                left--;right++;
            }
            if(maxLength<evenLengthCount){
                maxLength = evenLengthCount;
                maxString = s.substring(left+1,right);
            }
            
        }
        return maxString;
    }
}