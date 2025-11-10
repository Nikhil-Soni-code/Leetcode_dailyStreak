class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int max = 0;

        for (int x : set) {
            if (!set.contains(x - 1)) {
                int cur = x;
                int len = 1;

                while (set.contains(cur + 1)) {
                    cur++;
                    len++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }
}
