class MyHashSet {
    boolean[] hashSet;
    public MyHashSet() {
        hashSet = new boolean[1000001];
        Arrays.fill(hashSet,false);
    }
    
    public void add(int key) {
        if(!contains(key)){
            hashSet[key] = true;
        }
    }
    
    public void remove(int key) {
        hashSet[key] = false;
    }
    
    public boolean contains(int key) {
        return hashSet[key]!=false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */