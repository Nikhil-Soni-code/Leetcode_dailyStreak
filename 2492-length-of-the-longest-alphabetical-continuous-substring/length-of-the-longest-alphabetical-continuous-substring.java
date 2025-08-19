class Solution {
    public int longestContinuousSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int count = 1;
        int maxCount = 1;
        int prev = s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==prev+1){
                count++;
            }
            else{
                count=1;
            }
            maxCount = Math.max(maxCount,count);
            prev = s.charAt(i);

        }
        return maxCount;
    }
}