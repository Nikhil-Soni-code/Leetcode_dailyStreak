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
 class Pair{
    int val;
    ListNode node;
    public Pair(int val,ListNode node){
        this.val = val;
        this.node = node;
    }
 }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
            pq.add(new Pair(lists[i].val,lists[i]));
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while(pq.size()!=0){
            Pair pair = pq.poll();
            temp.next = pair.node;
            temp = temp.next;
            if(pair.node.next!=null){
                pq.add(new Pair(pair.node.next.val,pair.node.next));
            }
        }
        return dummyHead.next;
    }
}