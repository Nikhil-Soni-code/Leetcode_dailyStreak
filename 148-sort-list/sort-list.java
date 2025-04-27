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
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast!=null&&fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
    private ListNode sort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode rightNode = sort(middle.next);
        middle.next = null;
        ListNode leftNode = sort(head);
        return merge(leftNode,rightNode);
    }
    private ListNode merge(ListNode A,ListNode B){
        if(B==null)return A;
        if(A==null)return B;
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        ListNode tempA = A;
        ListNode tempB = B;

        while(tempA!=null&&tempB!=null){
            if(tempA.val<tempB.val){
                ListNode newNode = new ListNode(tempA.val);
                temp.next = newNode;
                tempA = tempA.next;
            }
            else{
                ListNode newNode = new ListNode(tempB.val);
                temp.next = newNode;
                tempB = tempB.next;
            }
            temp = temp.next;
        }
        if(tempA!=null){
            temp.next = tempA;
        }
        if(tempB!=null){
            temp.next = tempB;
        }
        return dummyHead.next;
    }
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
}