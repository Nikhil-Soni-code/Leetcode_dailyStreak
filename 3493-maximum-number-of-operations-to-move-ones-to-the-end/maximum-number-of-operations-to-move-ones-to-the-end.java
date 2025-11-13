class Solution {
    public int maxOperations(String s) {
        int opr = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
            else{
                opr+=count;
                while(i<s.length()&&s.charAt(i)=='0'){
                        i++;
                }i--;
            }
        }
        return opr;
    }
}