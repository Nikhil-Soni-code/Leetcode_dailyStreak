class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map = new HashMap();
        for(int i=0;i<messages.length;i++){
            map.put(senders[i],map.getOrDefault(senders[i],0)+messages[i].split(" ").length);
        }
        String ans = "";
        int count = 0;
        for(String key:map.keySet()){
            if(count<=map.get(key)){
                if(count==map.get(key)){
                    if(ans.compareTo(key)<0){
                        ans = key;
                    }
                }else{
                    ans = key;
                    count = map.get(key);
                }
            }
        }
        return ans;
    }
}