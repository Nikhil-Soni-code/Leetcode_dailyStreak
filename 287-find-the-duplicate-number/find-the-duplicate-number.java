class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize two pointers: slow and fast.
        // Both start at index 0.
        int slow = 0;
        int fast = 0;

        // Phase 1: Detecting the cycle using Floyd's Tortoise and Hare algorithm.
        do {
            slow = nums[slow];        // Move slow pointer one step ahead.
            fast = nums[nums[fast]];  // Move fast pointer two steps ahead.
        } while (slow != fast);       // Loop until both pointers meet inside the cycle.

        // Phase 2: Finding the duplicate number (entry point of the cycle).
        slow = 0;  // Reset slow pointer back to start.
        
        while (slow != fast) {   // Keep moving both pointers one step at a time.
            slow = nums[slow];   // Move slow pointer one step.
            fast = nums[fast];   // Move fast pointer one step.
        }

        return slow; // The point where they meet is the duplicate number.
    }
}
