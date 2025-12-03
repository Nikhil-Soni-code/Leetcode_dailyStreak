class Solution {
    public char findKthBit(int n, int k) {
        if(n==0)return '0';
        String Si = "0";
        for(int i=1;i<n;i++){
            String Si1 = Si + "1" +reverse(Si);
            // System.out.println(Si1);
            Si = Si1;
        }
        k = (k-1)%Si.length();
        return Si.charAt(k);
    }
    private String reverse(String S){
        StringBuilder sbr = new StringBuilder();
        for(char ch:S.toCharArray()){
            if(ch=='0')sbr.append('1');
            else sbr.append('0');
        }
        return sbr.reverse().toString();
    }
}