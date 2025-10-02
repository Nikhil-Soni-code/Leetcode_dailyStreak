class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drink = numBottles;
        int emptyBottles = numBottles;

        while(numBottles>=numExchange){
            drink++;
            numBottles-=numExchange;
            numBottles++;
            numExchange++;
        }
        return drink;
    }
}