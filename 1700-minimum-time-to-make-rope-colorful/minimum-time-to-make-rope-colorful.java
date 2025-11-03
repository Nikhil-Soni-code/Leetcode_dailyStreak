class Solution {
    public int minCost(String colors, int[] neededTime) {

        // Stores the final total cost of removing balloons
        int minCostRequired = 0;

        // Stores the cost for the current continuous group of same-colored balloons
        int cost = 0;

        // Start from index 1 because each balloon is compared with its previous one
        for(int i = 1; i < colors.length(); i++) {

            // Check if current balloon has the same color as the previous one
            if(colors.charAt(i) == colors.charAt(i - 1)) {

                // We must remove one of them to avoid having two same-color balloons side by side.
                // The cheaper balloon should be removed.
                cost += Math.min(neededTime[i], neededTime[i - 1]);

                // Explanation of the trick:
                //
                // We want to keep ONLY the balloon with the highest removal time (most expensive)
                // in the current chain.
                //
                // Example:
                // colors: ...bbb
                // times : [5, 4, 8]
                //
                // - Compare 4 with 5 → remove 4, keep 5 (max so far).
                // - But next we compare with 8. For that comparison, we should compare 8 with "5",
                //   because 5 is the balloon we kept.
                //
                // This means neededTime[i] must always store the MAX time seen in the chain so far.
                //
                // If current balloon time < previous balloon time,
                // the previous balloon is actually the one we are "keeping",
                // so we overwrite neededTime[i] with that larger value.
                if(neededTime[i] < neededTime[i - 1]) {
                    neededTime[i] = neededTime[i - 1];
                }

            } else {

                // When colors differ, the previous same-color chain ends here.
                // Add the accumulated cost for that chain.
                minCostRequired += cost;

                // Reset the chain cost for the next group
                cost = 0;
            }
        }

        // Add cost of the last chain (if it ended at the very last index)
        minCostRequired += cost;

        // Return total minimum cost
        return minCostRequired;
    }
}
