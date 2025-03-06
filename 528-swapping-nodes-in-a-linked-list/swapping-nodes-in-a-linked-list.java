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
        int length = 0;
        while(temp!=null){
            temp = temp.next;
            length++;
        }
        return length;
    }
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        int length = length(head);
        ListNode temp1 = head;
        int k1 = k;
        while(k1>1){
            temp1 = temp1.next;
            k1--;
        }
        ListNode temp2 = head;
        int k2 = length-k;
        while(k2!=0){
            temp2 = temp2.next;
            k2--;
        }
        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
        return head;



    }
}