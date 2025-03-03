class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        vector<int> ans(nums.size());
        int start = 0, mid = 0, end = 0;

        // Count elements less than, equal to, and greater than pivot
        for (int num : nums) {
            if (num < pivot) start++;
            else if (num == pivot) mid++;
        }

        end = start + mid; // Position for elements greater than pivot
        mid = start; // Mid should start where the pivot elements should be placed
        start = 0; // Reset start to use in second loop

        // Place elements in correct order
        for (int num : nums) {
            if (num < pivot) {
                ans[start++] = num;
            } else if (num == pivot) {
                ans[mid++] = num;
            } else {
                ans[end++] = num;
            }
        }

        return ans;
    }
};
