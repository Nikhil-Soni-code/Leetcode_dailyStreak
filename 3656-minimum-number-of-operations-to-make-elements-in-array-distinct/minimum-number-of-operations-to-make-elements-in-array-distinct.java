class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int k = 0;
        int count = 0;

        while (k < nums.length) {
            if (map.size() == nums.length - k) {
                break;
            }

            // Remove 3 elements starting from index k
            for (int i = k; i < k + 3 && i < nums.length; i++) {
                int val = nums[i];
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0) {
                    map.remove(val);
                }
            }

            k += 3;
            count++;
        }

        return count;
    }
}
