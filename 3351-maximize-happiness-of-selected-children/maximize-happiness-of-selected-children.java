class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long maxHappiness = 0;
        int decrement = 0;
        int i=happiness.length-1;
        while(k!=0 && i>=0){
            maxHappiness += Math.max(0,happiness[i--] - decrement);

            k--;
            decrement++;
        }
        return maxHappiness;
    }
}