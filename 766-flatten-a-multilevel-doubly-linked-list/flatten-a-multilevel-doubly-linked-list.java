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
    private Node flatDLL(Node head){
        Node curr = head;
        while(curr!=null){
            if(curr.child!=null){
                Node next = curr.next;
                curr.next = flatDLL(curr.child);
                curr.next.prev = curr;
                curr.child = null;
                while(curr.next!=null){
                    curr = curr.next;
                }
                
                curr.next = next;
                if(next!=null)
                next.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
    public Node flatten(Node head) {
        return flatDLL(head);


    }
}