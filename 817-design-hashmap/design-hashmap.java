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
    
    public void put(int key, int value) {
        int idx = hash(key);
        List<Pair> list = map.get(idx);
        for(Pair pair:list){
            if(pair.key==key){
                pair.val = value;
                return;
            }
        }
        list.add(new Pair(key,value));
    }
    
    public int get(int key) {
        int idx = hash(key);
        List<Pair> list = map.get(idx);
        for(Pair pair:list){
            if(pair.key==key){
                return pair.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        List<Pair> list = map.get(idx);
        for(Pair pair:list){
            if(pair.key==key){
                list.remove(pair);
                return;
            }
        }
    }
    private int hash(int k){
        return k%M;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */