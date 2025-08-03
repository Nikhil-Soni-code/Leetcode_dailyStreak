class Solution {
    private String convert(String s){
        char ele = s.charAt(0);
        int count = 1;
        StringBuilder sbr = new StringBuilder();
        for(int i=1;i<s.length();i++){
            if(ele==s.charAt(i)){
                count++;
            }
            else{
                sbr.append(count);
                sbr.append(ele);
                ele = s.charAt(i);
                count = 1;
            }
        }
        sbr.append(count);
        sbr.append(ele);
        return sbr.toString();
    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        return convert(countAndSay(n-1));
    }
}