class Solution {
    public long smallestNumber(long num) {
        // Base case: if input number is 0, return 0 directly
        if (num == 0) return 0;

        // Check if number is positive or negative
        boolean isPositive = (num > 0) ? true : false;

        // Work with absolute value (ignore sign for now)
        num = Math.abs(num);

        // Frequency array to count digits (0–9)
        long[] hash = new long[10];

        // Count occurrences of each digit
        while (num != 0) {
            hash[(int)(num % 10)]++; // increase count for that digit
            num /= 10; // remove last digit
        }

        // This will store the final answer
        long ans = 0;

        // ========== CASE 1: POSITIVE NUMBER ==========
        if (isPositive) {

            // Step 1: Find the smallest non-zero digit to avoid leading zeros
            int i = 1;
            while (i <= 9) {
                if (hash[i] > 0) {
                    ans = ans * 10 + i; // place smallest non-zero at start
                    hash[i]--; // use that digit once
                    break;
                }
                i++;
            }

            // Step 2: Add all zeros right after the first non-zero
            while (hash[0] != 0) {
                ans = ans * 10 + 0;
                hash[0]--;
            }

            // Step 3: Add all remaining digits in ascending order
            for (int j = i; j <= 9; j++) {
                while (hash[j] > 0) {
                    ans = ans * 10 + j;
                    hash[j]--;
                }
            }

            // Final smallest number for positive case
            return ans;
        }

        // ========== CASE 2: NEGATIVE NUMBER ==========
        else {
            // For negative numbers, we want the smallest possible value,
            // i.e., the largest number when digits are arranged in descending order,
            // and then multiplied by -1.

            for (int i = 9; i >= 0; i--) {
                while (hash[i] > 0) {
                    ans = ans * 10 + i; // add digits from 9 to 0
                    hash[i]--;
                }
            }

            // Negate the result to restore the sign
            return -1 * ans;
        }
    }
}
