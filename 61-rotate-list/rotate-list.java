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
        int size = 0;
        while(head!=null){
            head = head.next;
            size++;
        }return size;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int size = length(head);
        if(size==0)return head;
        k = k%size;
        if(size==0||k==0)return head;
        ListNode temp = head;
        ListNode prev = null;
        for(int i=0;i<size-k;i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        ListNode newHead = temp;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }
}