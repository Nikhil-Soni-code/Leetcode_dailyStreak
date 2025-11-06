class Pair{
    int key;
    int val;
    public Pair(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class MyHashMap {
    List<List<Pair>> map;
    int M;
    public MyHashMap() {
        map = new ArrayList();
        M = 769;
        for(int i=0;i<M;i++){
            map.add(new ArrayList());
        }
    }
    public int hash(int key){
        return key%M;
    }
    public void put(int key, int value) {
        int hash = hash(key);
        List<Pair> subAns = map.get(hash);
        for(Pair p:subAns){
            if(p.key==key){
                p.val = value;
                return;
            }
        }
        Pair newPair =  new Pair(key,value);
        subAns.add(newPair);
    }
    
    public int get(int key) {
        int hash = hash(key);
        List<Pair> subAns = map.get(hash);
        for(Pair p:subAns){
            if(p.key==key){
                return p.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = hash(key);
        List<Pair> subAns = map.get(hash);
        for(Pair p:subAns){
            if(p.key==key){
                subAns.remove(p);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */