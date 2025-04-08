class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int key,int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}
class LRUCache {
    ListNode head;
    ListNode tail;
    int size;
    int capacity;
    HashMap<Integer,ListNode> map;
    public LRUCache(int capacity) {
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
       head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap();
    }
    private void delete(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
    }
    private void addInFront(ListNode node){
        ListNode next = head.next;
        node.next = next;
        next.prev = node;
        head.next = node;
        node.prev = head;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            delete(node);
            addInFront(node);
            return node.val;
        }return -1;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            delete(node);
            addInFront(node);
            return;

        }
        if(size>=capacity){
            ListNode node = tail.prev;
            map.remove(node.key);
            delete(node);
            size--;
        }
        
        ListNode node = new ListNode(key,value);
        map.put(key,node);
        addInFront(node);
        size++;

        

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */