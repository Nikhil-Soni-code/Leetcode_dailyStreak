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
    private int findLength(ListNode head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;

    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = findLength(head);
        ListNode[] ans = new ListNode[k];
        ListNode temp = head;
        int elements = length/k;
        int elementsWithOneMoreElement = length%k;
        int idx = 0;
        while(temp!=null&&elementsWithOneMoreElement!=0){
            ListNode dummyHead = new ListNode(-1);
            ListNode temp1 = dummyHead;
            for(int i=0;i<elements+1&&temp!=null;i++){
                temp1.next = temp;
                temp1 = temp1.next;
                temp = temp.next;
            }
            temp1.next = null;
            ans[idx++] = dummyHead.next;
            elementsWithOneMoreElement--;
        }
        while(temp!=null){
            ListNode dummyHead = new ListNode(-1);
            ListNode temp1 = dummyHead;
            for(int i=0;i<elements&&temp!=null;i++){
                temp1.next = temp;
                temp1 = temp1.next;
                temp = temp.next;
            }
            temp1.next = null;
            ans[idx++] = dummyHead.next;
            elementsWithOneMoreElement--;
        }
        return ans;

    }
}