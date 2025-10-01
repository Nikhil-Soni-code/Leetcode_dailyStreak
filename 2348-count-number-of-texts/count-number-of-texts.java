class Solution {
    int MOD = 1000000007;
    private int count(String pressedKeys,int i,HashMap<Character,String> map,int[] dp){
        if(i==pressedKeys.length())return 1;
        if(dp[i]!=-1)return dp[i];
        String str = map.get(pressedKeys.charAt(i));
        int ways = 0;
        for(int j=i;j<pressedKeys.length();j++){
            if(pressedKeys.charAt(j)==pressedKeys.charAt(i)&&(j-i+1)<=str.length()){
                ways=(ways+count(pressedKeys,j+1,map,dp))%MOD;
            }
            else{
                break;
            }
        }
        dp[i] = ways;
        return ways;
    }
    public int countTexts(String pressedKeys) {
        HashMap<Character,String> map = new HashMap();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        int[]dp = new int[pressedKeys.length()];
        Arrays.fill(dp,-1);
        return count(pressedKeys,0,map,dp);
 

    }
}