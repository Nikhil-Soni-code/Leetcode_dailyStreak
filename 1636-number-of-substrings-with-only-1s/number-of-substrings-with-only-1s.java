class Solution {
    public int numSub(String s) {
        int i=0,j=0;
        int count = 0,MOD = 1000000007;
        while(j<s.length()){
            if(s.charAt(j)=='0'){
                j++;
                i=j;
            }else{
                count=(count+j-i+1)%MOD;
                j++;
            }
        }
        return count;
    }
}