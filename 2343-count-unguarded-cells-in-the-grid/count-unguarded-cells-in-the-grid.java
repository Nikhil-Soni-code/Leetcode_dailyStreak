class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] ans = new char[m][n];
        for (char[] a : ans) Arrays.fill(a, 'B');

        for (int i = 0; i < walls.length; i++) {
            ans[walls[i][0]][walls[i][1]] = 'W';
        }
                for (int i = 0; i < guards.length; i++) {
            ans[guards[i][0]][guards[i][1]] = 'X';
        }

        for (int k = 0; k < guards.length; k++) {
            int row = guards[k][0];
            int col = guards[k][1];

            int i = row - 1;
            while (i >= 0 && ans[i][col] != 'W' && ans[i][col] != 'X') {
                ans[i--][col] = 'G';
            }

            i = col - 1;
            while (i >= 0 && ans[row][i] != 'W' && ans[row][i] != 'X') {
                ans[row][i--] = 'G';
            }

            i = row + 1;
            while (i < m && ans[i][col] != 'W' && ans[i][col] != 'X') {
                ans[i++][col] = 'G';
            }

            i = col + 1;
            while (i < n && ans[row][i] != 'W' && ans[row][i] != 'X') {
                ans[row][i++] = 'G';
            }
        }

        int count = 0;
        for (char[] a : ans) {
            for (char b : a) if (b == 'B') count++;
        }
        return count;
    }
}
