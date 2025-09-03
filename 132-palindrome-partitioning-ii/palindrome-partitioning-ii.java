class Solution {
        private boolean isPalindrome(String s){
        int beg = 0,end = s.length()-1;
        while(beg<end){
            if(s.charAt(beg)!=s.charAt(end))return false;
            beg++;end--;
        }return true;
    }
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        for(int idx=s.length()-2;idx>=0;idx--){
            if(isPalindrome(s.substring(idx)))dp[idx] = 0;
            else{
                int ans = Integer.MAX_VALUE;
            for(int i=idx;i<s.length()-1;i++){
                if(isPalindrome(s.substring(idx,i+1))){
                    int cuts = 1+dp[i+1];
                    ans = Math.min(ans,cuts);
                }
            }
            dp[idx] = ans;
            }

        }return dp[0];
    }
}
// class Solution {
//     private int findMin(String s,int idx,int[] dp){
//         if(idx==s.length()-1||isPalindrome(s.substring(idx)))return 0;
//         if(dp[idx]!=-1)return dp[idx];
//         int ans = Integer.MAX_VALUE;
//         for(int i=idx;i<s.length()-1;i++){
//             if(isPalindrome(s.substring(idx,i+1))){
//                 int cuts = 1+findMin(s,i+1,dp);
//                 ans = Math.min(ans,cuts);
//             }
//         }
//         dp[idx] = ans;
//         return ans;
//     }
//     private boolean isPalindrome(String s){
//         int beg = 0,end = s.length()-1;
//         while(beg<end){
//             if(s.charAt(beg)!=s.charAt(end))return false;
//             beg++;end--;
//         }return true;
//     }
//     public int minCut(String s) {
//         int[] dp = new int[s.length()];
//         Arrays.fill(dp,-1);
//         return findMin(s,0,dp);
//     }
// }