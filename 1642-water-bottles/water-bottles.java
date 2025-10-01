class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = numBottles;
        int emptyBottles=numBottles%numExchange;
        numBottles /= numExchange;
        while(numBottles>0)
        {
            drink+=numBottles;
            int totalBottles = (numBottles+emptyBottles);
            numBottles=totalBottles/numExchange;
            emptyBottles = totalBottles%numExchange;
        }
        return drink;
    }
}