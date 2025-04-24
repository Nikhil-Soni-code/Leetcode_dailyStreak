class Solution {
    public int numSub(String s) {
        int count = 0;
        int i=0,j=0;
        while(j<s.length()){
            if(s.charAt(j)!='0'){
                i=j;
                while(j<s.length()&&s.charAt(j)!='0'){
                    count = (count + (j - i + 1)) % 1000000007;
                    j++;
                }
            }
            j++;
        }
        return count;
    }
}