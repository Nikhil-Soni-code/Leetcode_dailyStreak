class MyHashSet {
    List<LinkedList<Integer>> set;
    int M;
    public MyHashSet() {
        set = new ArrayList();
        M = 769;
        for(int i=0;i<M;i++){
            set.add(new LinkedList<>());
        }
    }
    private int hash(int k){
        return k%M;
    }
    public void add(int key) {
        int idx = hash(key);
        LinkedList<Integer> list = set.get(idx);
        if(!list.contains(key)){
            list.add(key);
        }
        
    }
    
    public void remove(int key) {
        int idx = hash(key);
        LinkedList<Integer> list = set.get(idx);
        if(list.contains(key)){
            list.remove((Integer)key);
        }
    }
    
    public boolean contains(int key) {
        int idx = hash(key);
        LinkedList<Integer> list = set.get(idx);
        return list.contains(key);
          
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */