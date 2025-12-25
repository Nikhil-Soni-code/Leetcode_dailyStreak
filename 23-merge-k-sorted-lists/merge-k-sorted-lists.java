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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node:lists){
            if(node!=null)pq.add(node);
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;

            if(node.next != null){
                pq.add(node.next);
            }
        }
        return dummyHead.next;
    }
}