class Solution {
    private boolean isDigit(String n){
        if(n.length()==0)return false;
        for(char ch:n.toCharArray()){
            if(!Character.isDigit(ch))return false;
        }return true;
    }
    private boolean isValid(String n){
        if(n.length()>4||n.length()==0){
            return false;
        }
        HashSet<Character> set  = new HashSet();
        set.add('a');
        set.add('b');
        set.add('c');
        set.add('d');
        set.add('e');
        set.add('f');

        set.add('A');
        set.add('B');
        set.add('C');
        set.add('D');
        set.add('E');
        set.add('F');

        for(char ch:n.toCharArray()){
            if(!Character.isDigit(ch)&&!set.contains(ch))return false;
        }
        return true;
    }
    public String validIPAddress(String queryIP) {
        if(queryIP.indexOf('.')!=-1){
            String[] ip = queryIP.split("\\.");
            int dot = 0;
            for(int i=0;i<queryIP.length();i++){
                if(queryIP.charAt(i)=='.')dot++;
            }
            if(ip.length!=4||dot!=3)return "Neither";
            for(int i=0;i<ip.length;i++){
                if((!isDigit(ip[i])||ip[i].length()>4||Integer.parseInt(ip[i])>255)||(ip[i].charAt(0)=='0'&&ip[i].length()>1)){
                    return "Neither";
                }
            }
            return "IPv4";

        }
        else if(queryIP.indexOf(':')!=-1){
            String[] ip = queryIP.split("\\:");
            int colon = 0;
            for(int i=0;i<queryIP.length();i++){
                if(queryIP.charAt(i)==':')colon++;
            }
            if(ip.length!=8||colon!=7)return "Neither";
            for(int i=0;i<ip.length;i++){
                if(!isValid(ip[i]))return "Neither";
            }
            return "IPv6";


        }else{
            return "Neither";
        }
    }
}