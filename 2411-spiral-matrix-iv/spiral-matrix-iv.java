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
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = -1;
            }
        }
        ListNode temp = head;
        int row_i=-1;
        int col_i=-1;
        int i=0,j=0;
        while(temp!=null){
            while(j<n&&temp!=null){
                mat[i][j] = temp.val;
                temp = temp.next;
                j++;
            }
            j--;
            row_i = i;
            i++;
            while(i<m&&temp!=null){
                mat[i][j] = temp.val;
                temp = temp.next;
                i++;
            }
            i--;
            n--;
            j--;
            while(j>col_i&&temp!=null){
                mat[i][j] = temp.val;
                temp = temp.next;
                j--;
            }
            j++;
            i--;
            m--;
            while(i>row_i&&temp!=null){
                                mat[i][j] = temp.val;
                temp = temp.next;
                i--;
            }
            i++;
            col_i = j;
            j++;
        }

        return mat;
    }
}