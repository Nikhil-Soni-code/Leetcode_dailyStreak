class Solution {
    private int[] find_coordinates(int num, int n, int m) {
        int row_top = (num - 1) / m;           // how many full rows from bottom have been passed
        int row_bottom = (n - 1) - row_top;    // actual row index in board[][]
        int col = (num - 1) % m;

        // Correct flip: flip when row_top is odd
        if (row_top % 2 == 1) {
            col = m - 1 - col;
        }

        return new int[]{row_bottom, col};
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int N = n * n;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(1);
        visited[1] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int curr = queue.poll();
                if (curr == N) return steps;

                for (int i = curr + 1; i <= Math.min(curr + 6, N); i++) {
                    // compute board coordinates for square i
                    int[] co = find_coordinates(i, n, n);
                    int r = co[0], c = co[1];

                    int dest = (board[r][c] == -1) ? i : board[r][c];

                    if (!visited[dest]) {
                        visited[dest] = true;   // mark the final destination
                        queue.add(dest);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
