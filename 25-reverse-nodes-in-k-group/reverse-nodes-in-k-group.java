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
    private int findLength(ListNode head){
        int length = 0;
        while(head!=null){
            head = head.next;
            length++;
        }
        return length;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = findLength(head);
        if(head==null||head.next==null||length<k)return head;
        int i=1;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while(i<k){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
            i++;
        }
        curr.next = prev;
        head.next = reverseKGroup(next,k);
        return curr;

    }
}