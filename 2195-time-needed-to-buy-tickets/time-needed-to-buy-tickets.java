class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0,i=0;
        while(tickets[k]!=0){
            if(tickets[i]!=0){
                tickets[i]--;
                time++;
            }
                i = (i+1)%tickets.length;

        }
        return time;
    }
}