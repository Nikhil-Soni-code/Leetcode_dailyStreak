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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode newHead = head.next;
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        ListNode prev = null;
        while(temp1!=null&&temp2!=null){
            temp1.next = temp2.next;
            temp2.next = temp1;
            if(prev!=null)
            {
                prev.next = temp2;
            }
            prev = temp1;
            temp1 = temp1.next;
            if(temp1!=null)temp2 = temp1.next;
        }
        return newHead;
    }
}