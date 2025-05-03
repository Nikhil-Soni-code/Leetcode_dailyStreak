class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // We will try to make all values in 'tops' or 'bottoms' equal to either tops[0] or bottoms[0]
        // and count how many rotations are needed in each scenario.

        int count1 = 0; // Count of rotations to make all 'tops' elements equal to tops[0]
        int count2 = 0; // Count of rotations to make all 'tops' elements equal to bottoms[0]
        int count3 = 0; // Count of rotations to make all 'bottoms' elements equal to tops[0]
        int count4 = 0; // Count of rotations to make all 'bottoms' elements equal to bottoms[0]

        int domino1 = tops[0];     // Candidate value from tops
        int domino2 = bottoms[0];  // Candidate value from bottoms

        for (int i = 0; i < tops.length; i++) {

            // Case 1: Make all tops[i] equal to domino1 (tops[0])
            // If current top is not domino1 but bottom is, we need a rotation
            if (bottoms[i] == domino1 && tops[i] != domino1) {
                if (count1 != Integer.MAX_VALUE) count1++;
            } 
            // If neither top nor bottom is domino1, it's not possible
            else if (bottoms[i] != domino1 && tops[i] != domino1) {
                count1 = Integer.MAX_VALUE;
            }

            // Case 2: Make all tops[i] equal to domino2 (bottoms[0])
            if (bottoms[i] == domino2 && tops[i] != domino2) {
                if (count2 != Integer.MAX_VALUE) count2++;
            } else if (bottoms[i] != domino2 && tops[i] != domino2) {
                count2 = Integer.MAX_VALUE;
            }

            // Case 3: Make all bottoms[i] equal to domino1 (tops[0])
            if (tops[i] == domino1 && bottoms[i] != domino1) {
                if (count3 != Integer.MAX_VALUE) count3++;
            } else if (bottoms[i] != domino1 && tops[i] != domino1) {
                count3 = Integer.MAX_VALUE;
            }

            // Case 4: Make all bottoms[i] equal to domino2 (bottoms[0])
            if (tops[i] == domino2 && bottoms[i] != domino2) {
                if (count4 != Integer.MAX_VALUE) count4++;
            } else if (bottoms[i] != domino2 && tops[i] != domino2) {
                count4 = Integer.MAX_VALUE;
            }
        }

        // Find the minimum among all 4 valid rotation counts
        int ans = Math.min(count1, Math.min(count2, Math.min(count3, count4)));

        // If all scenarios failed (i.e., Integer.MAX_VALUE), return -1
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
