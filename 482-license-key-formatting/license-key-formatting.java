class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int x = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='-')continue;
            ans.append(Character.toUpperCase(s.charAt(i)));
            x++;
            if(x==k&&i!=0){
                ans.append('-');
                x=0;
            }
        }
        String ns = ans.reverse().toString();
        if(ns.length()>0&&ns.charAt(0)=='-')ns = ns.substring(1);
        return ns;


    }
}