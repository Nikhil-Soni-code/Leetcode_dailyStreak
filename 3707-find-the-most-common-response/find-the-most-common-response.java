class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String,Integer> map = new HashMap(); 
        for(int i=0;i<responses.size();i++){
            HashSet<String> set = new HashSet();
            for(int j=0;j<responses.get(i).size();j++){
                set.add(responses.get(i).get(j));
            }
            for(String s:set){
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        int count = 0;
        String ans = "";
        for(String key:map.keySet()){
            if(map.get(key).equals(count)){
                if(key.compareTo(ans)<0){
                    ans = key;
                }
            }
            else if(map.get(key)>count){
                ans = key;
                count = map.get(key);
            }

        }
        return ans;
    }
}