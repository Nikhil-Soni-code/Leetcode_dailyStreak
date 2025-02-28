/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        if(head==null||head.next==null){
            return null;
        }
        ListNode fast = head;
        do{
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                fast = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }while(fast!=null&&fast.next!=null&&slow!=fast);
        return null;

    }
}