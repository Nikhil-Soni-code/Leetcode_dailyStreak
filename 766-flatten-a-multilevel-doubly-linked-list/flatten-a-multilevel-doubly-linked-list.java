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
        Node nextNode = flatten(head.next);
        Node childNode = flatten(head.child);
        head.child = null;
        if(childNode!=null){
            head.next = childNode;
            childNode.prev = head;
            Node tail = findTail(childNode);
            if (nextNode != null) {
                tail.next = nextNode;
                nextNode.prev = tail;
            }

        }else{
            head.next = nextNode;
            if(nextNode!=null)
            nextNode.prev = head;
        }
        return head;
    }
    private Node findTail(Node node){
        while(node.next!=null){
            node = node.next;
        }return node;
    }
}