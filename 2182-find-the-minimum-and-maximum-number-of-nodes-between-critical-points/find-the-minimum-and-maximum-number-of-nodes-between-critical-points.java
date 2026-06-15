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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)return new int[]{-1,-1};
        int first = -1;
        int recent = -1;
        ListNode prev = head;
        ListNode temp = head.next;
        ListNode next = temp.next;
        int pos = 1;
        int minDist = Integer.MAX_VALUE;
        while(next!=null){
            if(prev.val>temp.val && temp.val<next.val || prev.val<temp.val && temp.val>next.val){
                if(first==-1){
                    first = pos;
                    recent = pos;
                }else{
                    minDist = Math.min(minDist,pos-recent);
                    recent = pos;
                }
            }
            prev = temp;
            temp = next;
            next = next.next;
            pos++;
        }
        if(minDist==Integer.MAX_VALUE)return new int[]{-1,-1};
        return new int[]{minDist,recent-first};
    }
}