class Solution {
    public long minCost(String s, int[] cost) {
        long[] deletion = new long[26];
        for(int i=0;i<s.length();i++){
            deletion[s.charAt(i)-'a']+=cost[i];
        }
        long totalCost = 0;
        for(int i=0;i<cost.length;i++)totalCost+=cost[i];
        long minDeletions = totalCost;
        for(int i=0;i<26;i++){
            if(deletion[i]!=0)
            minDeletions = Math.min(minDeletions,totalCost-deletion[i]);
        }return minDeletions;
    }
}