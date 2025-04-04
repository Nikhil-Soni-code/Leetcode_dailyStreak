/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];

        // Initialize all cells with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = -1;
            }
        }

        ListNode temp = head;

        // Track boundaries for spiral traversal
        int rowStart = -1, colStart = -1;
        int i = 0, j = 0;

        while (temp != null) {
            // Traverse right
            while (j < n && temp != null) {
                mat[i][j] = temp.val;
                temp = temp.next;
                j++;
            }
            j--;
            rowStart = i;
            i++;

            // Traverse down
            while (i < m && temp != null) {
                mat[i][j] = temp.val;
                temp = temp.next;
                i++;
            }
            i--;
            n--; // Right boundary moves left
            j--;

            // Traverse left
            while (j > colStart && temp != null) {
                mat[i][j] = temp.val;
                temp = temp.next;
                j--;
            }
            j++;
            i--;
            m--; // Bottom boundary moves up

            // Traverse up
            while (i > rowStart && temp != null) {
                mat[i][j] = temp.val;
                temp = temp.next;
                i--;
            }
            i++;
            colStart = j;
            j++;
        }

        return mat;
    }
}
