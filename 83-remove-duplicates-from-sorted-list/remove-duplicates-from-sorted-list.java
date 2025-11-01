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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        ListNode newNode = new ListNode(head.val);
        head = head.next;
        temp.next = newNode;
        temp = temp.next;
        while(head!=null){
            if(head.val!=temp.val){
                newNode = new ListNode(head.val);
                temp.next = newNode;
                temp = temp.next;
            }
            head = head.next;
        }
        return dummyHead.next;
    }
}