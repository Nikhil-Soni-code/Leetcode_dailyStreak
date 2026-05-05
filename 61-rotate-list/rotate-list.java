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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int length = 0;
        while(temp!=null){
            temp = temp.next;
            length ++;
        }
        if(length==0)return head;
    
        k = k%length;
        if(k==0)return head;
        ListNode newTail = null;
        ListNode newHead = head;
        
        int count = 0;
        while(count<length-k){
            newTail = newHead;
            newHead = newHead.next;

            count++;
        }

        newTail.next = null;
        temp = newHead;
        while(temp.next!=null)temp = temp.next;
        temp.next = head;
        return newHead;
    }
}