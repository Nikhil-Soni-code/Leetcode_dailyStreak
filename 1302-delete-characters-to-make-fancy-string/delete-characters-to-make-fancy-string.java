class Solution {
    public String makeFancyString(String s) {
        StringBuilder sbr = new StringBuilder(s);
        int i=1;
        while(i<s.length()){
            if(i<sbr.length()-1&&sbr.charAt(i)==sbr.charAt(i-1)&&sbr.charAt(i)==sbr.charAt(i+1)){
                sbr.deleteCharAt(i);
            }
            else{
                i++;
            }
        }
        return sbr.toString();
    }
}