class Node{
    int val;
    Node next;
    Node prev;
    public Node(int val){
        this.val = val;
    }
}
class MyLinkedList {
    Node head;
    Node tail;
    int length;
    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    private Node getNode(int index){
        int idx = 0;
        Node temp = head;
        while(idx!=index){
            temp = temp.next;
            idx++;
        }
        return temp;
    }
    public int get(int index) {
        if(index<0||index>=length){
            return -1;
        }
        return getNode(index).val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head==null){
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.prev = null;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }
    
    public void addAtTail(int val) {
                Node newNode = new Node(val);
        if(tail==null){
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.prev = tail;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>length){
            return;
        }
        if(index==0){
            addAtHead(val);
            
            return;
        }
        if(index==length){
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);
        Node node = getNode(index-1);
        newNode.next = node.next;
        node.next.prev = newNode;

        node.next = newNode;
        newNode.prev = node;
        length++;
    }
    
    public void deleteAtIndex(int index) {
              if(index>=length||length==0){
            return;
        }
        if(index == 0){
            head = head.next;
        length--;

            return;
        }
        if(index==length-1){
            tail = tail.prev;
        length--;

            return;
        }
  
        Node node = getNode(index);
        node.prev.next = node.next;
        if(node.next!=null){
        node.next.prev = node.prev;
            
        }
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */