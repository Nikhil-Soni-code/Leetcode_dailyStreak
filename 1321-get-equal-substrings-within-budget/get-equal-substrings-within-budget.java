class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int start = 0;
        int end = 0;
        int n = s.length();
        while(end<n){
            maxCost-=Math.abs(s.charAt(end)-t.charAt(end));
            while(maxCost<0){
                maxCost+=Math.abs(s.charAt(start)-t.charAt(start));
                start++;
            }
            ans = Math.max(ans,end-start+1);
            end++;
        
        }
        
        return ans;
    }
}