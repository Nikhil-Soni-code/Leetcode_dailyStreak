class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,Integer> map = new HashMap();
        int count = 0;
        for(char ch : word.toCharArray()){
            if(ch >= 97){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }
        for(char ch : word.toCharArray()){
            if(ch >= 97 && map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
            }else{
                if(map.containsKey(Character.toLowerCase(ch))){
                    if(map.get(Character.toLowerCase(ch))==0){
                        count++;
                    }
                    map.remove(Character.toLowerCase(ch));
                }
            }
        }return count;
    }
}