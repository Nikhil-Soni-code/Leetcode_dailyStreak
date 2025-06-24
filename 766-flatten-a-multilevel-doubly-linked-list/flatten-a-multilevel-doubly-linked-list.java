/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return null;
        }
        Node bottomHead = flatten(head.child);
        Node nextHead = flatten(head.next);
        if(bottomHead!=null){
            head.next = bottomHead;
            bottomHead.prev = head;
            head.child = null;
            Node tail = bottomHead;
            while(tail.next!=null){
                tail = tail.next;
            }
            tail.next = nextHead;
            if(nextHead!=null){

            nextHead.prev = tail;}
        }else{
            head.next = nextHead;
            if(nextHead!=null){
            nextHead.prev = head;

            }
        }
        return head;
    }
}