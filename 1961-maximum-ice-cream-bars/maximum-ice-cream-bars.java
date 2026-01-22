class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for(int i=0;i<costs.length;i++){
            max = Math.max(max,costs[i]);
        }
        int[] countArray = new int[max+1];
        for(int i=0;i<costs.length;i++){
            countArray[costs[i]]++;
        }

        int count = 0;
        for(int i=0;i<=max;i++){
            if(countArray[i]==0)continue;
            if(i <= coins){
                if((countArray[i]*i) <= coins){
                    count+=countArray[i];
                    coins-=(countArray[i]*i);
                }else{
                    count+=(coins/i);
                    break;
                }
            }else{
                break;
            }
        }
        return count;
    }
}