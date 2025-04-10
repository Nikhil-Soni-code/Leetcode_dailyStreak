class Pair{
    String word;
    int freq;
    public Pair(String word,int freq){
        this.word = word;
        this.freq = freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList();
        HashMap<String,Integer> map = new HashMap();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) {
                return a.word.compareTo(b.word); // Lexicographical comparison
            } else {
                return b.freq-a.freq; // Lower frequency has higher priority
            }
        });

        for(String key:map.keySet()){
            pq.add(new Pair(key,map.get(key)));

        }
        for(int i=0;i<k;i++){
            ans.add(pq.poll().word);
        }
        return ans;
    }
}