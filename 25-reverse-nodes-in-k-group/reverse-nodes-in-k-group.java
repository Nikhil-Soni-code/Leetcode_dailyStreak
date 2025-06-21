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
    private boolean isLengthK(ListNode head,int k){
        int count = 0;
        while(head!=null){
            head=head.next;count++;
            if(count==k)return true;

        }return false;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        boolean isLengthK = isLengthK(head,k);
        if(!isLengthK||k==1)return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        int count = 0;
        while(count<k){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
            count++;
        }
        head.next = reverseKGroup(curr,k);
        return prev;        
    }
}