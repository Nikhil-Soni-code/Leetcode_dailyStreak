// Custom Pair class to store the value along with its list index (i) and element index within the list (j)
class Pair {
    int value;
    int i;
    int j;

    public Pair(int value, int i, int j) {
        this.value = value;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Initialize result with a wide range
        int[] result = {-100000, 100000};

        // Min heap to keep track of the minimum element in the current window
        PriorityQueue<Pair> minPq = new PriorityQueue<>((a, b) -> a.value - b.value);

        int maxElement = Integer.MIN_VALUE;

        // Step 1: Push the first element of each list into the min heap
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minPq.add(new Pair(value, i, 0));
            maxElement = Math.max(maxElement, value); // Track the current max element
        }

        // Step 2: Start sliding the window
        while (true) {
            // Remove the smallest element (min) from the heap
            Pair minPair = minPq.poll();
            int minElement = minPair.value;

            // Check if current window [minElement, maxElement] is smaller than previous best range
            if ((result[1] - result[0]) >= (maxElement - minElement)) {
                // If range is same but minElement is smaller, update result
                if ((result[1] - result[0]) == (maxElement - minElement)) {
                    if (result[0] > minElement) {
                        result[0] = minElement;
                        result[1] = maxElement;
                    }
                } else {
                    result[0] = minElement;
                    result[1] = maxElement;
                }
            }

            int i = minPair.i;
            int j = minPair.j;

            // Move to the next element in the same list (if exists)
            if (j < nums.get(i).size() - 1) {
                int newElement = nums.get(i).get(j + 1);
                // Update the maxElement if needed
                maxElement = Math.max(maxElement, newElement);
                // Push the next element into the heap
                minPq.add(new Pair(newElement, i, j + 1));
            } else {
                // If we reached the end of one of the lists, we can't cover all lists anymore
                break;
            }
        }

        return result;
    }
}
