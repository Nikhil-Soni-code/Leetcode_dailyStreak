class Pair{
    char ch;
    int count;
    public Pair(char ch,int count){
        this.ch = ch;
        this.count = count;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        Pair[] arr = new Pair[map.size()];
        int idx = 0;
        for(Character ch:map.keySet()){
            arr[idx++] = new Pair(ch,map.get(ch));
        }
        Arrays.sort(arr,(a,b)-> b.count-a.count);
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            ans.append(String.valueOf(arr[i].ch).repeat(arr[i].count));
        }
        return ans.toString();
        
    }
}