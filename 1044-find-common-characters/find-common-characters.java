class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0;i<words[0].length();i++){
            map.put(words[0].charAt(i),map.getOrDefault(words[0].charAt(i),0)+1);
        }
        for(int i=0;i<words.length;i++){
            HashMap<Character,Integer> map2 = new HashMap();
            for(int j=0;j<words[i].length();j++){
                map2.put(words[i].charAt(j),map2.getOrDefault(words[i].charAt(j),0)+1);
            }
            for(Character key:map.keySet()){
                if(map2.containsKey(key)){
                    map.put(key,Math.min(map.get(key),map2.get(key)));
                }else{
                    map.put(key,0);
                }
            }
        }
        List<String> list = new ArrayList();
        for(Character key:map.keySet()){
            int count  = map.get(key);
            while(count!=0){
                list.add(key+"");
                count--;
            }
        }
        return list;
    }
}