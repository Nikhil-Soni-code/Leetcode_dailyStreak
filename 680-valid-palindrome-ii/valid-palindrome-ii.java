class Solution {
    private boolean isPalindrome(int i,String s,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        int count = 0;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                count++;

                return isPalindrome(i+1,s,j)||isPalindrome(i,s,j-1);
            }
            i++;j--;
        }
        return count==0;
    }
}