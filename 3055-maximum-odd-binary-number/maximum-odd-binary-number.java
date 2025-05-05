class Solution {
    public String maximumOddBinaryNumber(String s) {
        String ans = "";
        int noOfOnes = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                noOfOnes++;
            }
        }
        noOfOnes--;
        int i=0;
        while(noOfOnes!=0){
            ans+='1';
            noOfOnes--;i++;
        }
        for(int j=i;j<s.length()-1;j++){
            ans+='0';
        }
        ans+='1';
        return ans;

    }
}