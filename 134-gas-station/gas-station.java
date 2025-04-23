class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalCost>totalGas){
            return -1;
        }
        int ans=-1;
        int fuel = 0;
        for(int i=0;i<gas.length;i++){
            fuel+=gas[i];
            if(fuel<cost[i]){
                fuel = 0;
                ans = -1;
            }else{
                if(ans==-1){
                    ans = i;
                }
                fuel -=cost[i];
            }
            

        }
        return ans;

    }
}