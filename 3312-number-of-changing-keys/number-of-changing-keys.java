class Solution {
    public int countKeyChanges(String s) {
        int count = 0;
        for(int i=1 ; i<s.length() ; i++){
            char ch1 = Character.toLowerCase(s.charAt(i));
            char ch2 = Character.toLowerCase(s.charAt(i-1));
            if(ch1 != ch2)count++;
        }return count;
    }
}