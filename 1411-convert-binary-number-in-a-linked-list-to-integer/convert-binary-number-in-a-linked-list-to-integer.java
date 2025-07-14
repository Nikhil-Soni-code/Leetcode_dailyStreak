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
    private ListNode reverse(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
        }
        return prev;
    }
    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode temp = reverse(head);
        int pow = 1;
        while(temp!=null){
            result = result+temp.val*pow;
            pow*=2;
            temp = temp.next;
        }
        return result;
    }
}