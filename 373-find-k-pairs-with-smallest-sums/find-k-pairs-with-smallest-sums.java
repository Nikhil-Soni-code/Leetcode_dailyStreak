import java.util.*;

class Pair {
    int[] pair;
    int[] idx;

    public Pair(int ele1, int ele2, int i, int j) {
        this.pair = new int[]{ele1, ele2};
        this.idx = new int[]{i, j};
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->
            (a.pair[0] + a.pair[1]) - (b.pair[0] + b.pair[1])
        );

        // Add first pair
        pq.add(new Pair(nums1[0], nums2[0], 0, 0));

        // Use HashSet to track visited indices (encoded as a string)
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        while (ans.size() < k) {
            Pair ele = pq.poll();
            ans.add(Arrays.asList(ele.pair[0], ele.pair[1]));

            int i = ele.idx[0];
            int j = ele.idx[1];

            if (i + 1 < nums1.length && !visited.contains((i + 1) + "," + j)) {
                pq.add(new Pair(nums1[i + 1], nums2[j], i + 1, j));
                visited.add((i + 1) + "," + j);
            }

            if (j + 1 < nums2.length && !visited.contains(i + "," + (j + 1))) {
                pq.add(new Pair(nums1[i], nums2[j + 1], i, j + 1));
                visited.add(i + "," + (j + 1));
            }
        }

        return ans;
    }
}
