class Solution {
    public int minCost(String colors, int[] neededTime) {

        // This will store the total cost of removing balloons
        int minCostRequired = 0;

        // This stores the cost for the current group of same-color balloons
        int cost = 0;

        // Start from index 1 because we compare each balloon with the previous one
        for(int i = 1; i < colors.length(); i++) {

            // If two adjacent balloons have the same color
            if(colors.charAt(i) == colors.charAt(i - 1)) {

                // We must remove ONE of them to avoid adjacent duplicates.
                // Remove the one with the smaller time (cheaper removal).
                cost += Math.min(neededTime[i], neededTime[i - 1]);

                // Important trick:
                // We want the "remaining" balloon in this chain to always be the most expensive one.
                // So if current balloon is cheaper than previous, we replace its time with previous.
                // This keeps neededTime[i] as the *max* of the chain so far.
                if(neededTime[i] < neededTime[i - 1]) {
                    neededTime[i] = neededTime[i - 1];
                }

            } else {
                // If colors differ, the previous "same-color chain" ends here.
                // Add its accumulated cost.
                minCostRequired += cost;

                // Reset for next chain
                cost = 0;
            }
        }

        // Add the cost of the last chain (if any)
        minCostRequired += cost;

        // Total minimum cost required to remove balloons
        return minCostRequired;
    }
}
