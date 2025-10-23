class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder ans = new StringBuilder();
        while(s.length()>2){
            for(int i=0;i<s.length()-1;i++){
                ans.append((s.charAt(i)+s.charAt(i+1)-'0')%10);
            }
            s = ans.toString();
            ans.setLength(0);
        }
        return s.charAt(0)==s.charAt(1);
    }
}