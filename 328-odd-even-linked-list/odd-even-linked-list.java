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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);

        ListNode temp1 = oddHead;
        ListNode temp2 = evenHead;
        ListNode temp3 = head;
        ListNode temp4 = head.next;

        while(temp3!=null&&temp4!=null){
            temp1.next = temp3;
            temp2.next = temp4;
            temp1 = temp1.next;
            temp2 = temp2.next;
            temp3 = temp3.next.next;
            if(temp4.next==null){
                break;
            }
            temp4 = temp4.next.next;
        }
        if(temp3!=null){
            temp1.next = temp3;
            temp1 = temp1.next;
        }
        temp1.next = evenHead.next;
        temp2.next = null;
        return oddHead.next;
    }
}