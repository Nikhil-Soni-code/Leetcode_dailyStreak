class Solution {
    private int[] find_coordinates(int num,int n,int m){
        int row_top = (num - 1) / m;
        int row_bottom = (n - 1) - row_top;
        int col = (num - 1) % m;

        if (row_top % 2 == 1) {
            col = m - 1 - col;
        }

        return new int[]{row_bottom, col};
    }

    public int snakesAndLadders(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[board.length * board.length + 1];

        queue.add(1);
        visited[1] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int curr = queue.poll();

                if (curr == board.length * board.length)
                    return steps;

                for (int i = curr + 1; i <= Math.min(curr + 6, board.length * board.length); i++) {
                    int[] co = find_coordinates(i, board.length, board[0].length);
                    int row = co[0], col = co[1];

                    int dest = (board[row][col] == -1) ? i : board[row][col];

                    // MINIMAL FIX:
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.add(dest);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
