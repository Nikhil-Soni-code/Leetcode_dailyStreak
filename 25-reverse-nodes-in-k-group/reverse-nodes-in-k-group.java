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
        if(length<k||head==null||head.next==null)return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        int i=0;
        while(i<k&&curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
            i++;
        }
        head.next = reverseKGroup(curr,k);
        return prev;

    }
}