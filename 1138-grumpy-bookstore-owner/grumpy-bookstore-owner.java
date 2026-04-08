class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        for(int i=0 ; i<customers.length ; i++){
            if(grumpy[i] ==0 ){
                ans+=customers[i];
            }
        }
        int i=0,j=0;
        int sum = 0;
        while(j<minutes){
            if(grumpy[j] == 1){
                sum += customers[j];
            }j++;
        }
        int max = sum;
        while(j<customers.length){
            if(grumpy[j]==1)sum+=customers[j];
            j++;
            if(grumpy[i]==1)sum-=customers[i];
            i++;
            max = Math.max(max,sum);
        }return max+ans;
        
    }
}