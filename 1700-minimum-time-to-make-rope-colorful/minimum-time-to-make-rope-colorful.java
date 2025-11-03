class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minCostRequired = 0;
        int cost = 0;
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                cost+=Math.min(neededTime[i],neededTime[i-1]);
                if(neededTime[i]<neededTime[i-1]){
                    neededTime[i] = neededTime[i-1];
                }
            }else{
                minCostRequired+=cost;
                cost = 0;
            }
        }
        minCostRequired+=cost;

        return minCostRequired;
    }
}