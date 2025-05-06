class Solution {
    public String longestPalindrome(String s) {
        String ans = s.charAt(0)+"";
        int maxLength = 1;
        for(int i=1;i<s.length();i++){
            //oddLength substring
            int l = i-1;
            int r = i+1;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                if(maxLength<r-l+1){
                    maxLength = r-l+1;
                    ans = s.substring(l,r+1);
                }
                r++;l--;
            }

            //evenLength substring
            l = i-1;
            r = i;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                if(maxLength<r-l+1){
                    maxLength = r-l+1;
                    ans = s.substring(l,r+1);
                }
                r++;l--;
            }
        }
        return ans;
    }
}