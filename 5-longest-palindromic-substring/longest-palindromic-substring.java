class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 1;
        String maxString = ""+s.charAt(0);
        for(int i=1;i<s.length();i++){
            int j=i-1,k=i+1;
            while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
                if(maxLength<k-j+1){
                    maxLength = k-j+1;
                    maxString = s.substring(j,k+1);
                }
                j--;k++;
            }
            j=i-1;k=i;
            while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
                if(maxLength<k-j+1){
                    maxLength = k-j+1;
                    maxString = s.substring(j,k+1);
                }
                j--;k++;
            }
        }
        return maxString;
    }
}