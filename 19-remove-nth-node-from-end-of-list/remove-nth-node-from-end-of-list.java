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
    private int length(ListNode head){
        ListNode temp = head;
        int length=0;
        while(temp!=null){
            temp = temp.next;
            length++;
        }
        return length;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = length(head);
        System.out.println(length);
        if(n==length){
            return head.next;
        }
        length = length-n-1;
        ListNode temp = head;
        while(length>0){
            temp = temp.next;
            length--;
        }
        temp.next = temp.next.next;
        return head;

    }
}