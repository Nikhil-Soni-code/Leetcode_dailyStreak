class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList();
        HashSet<String> map = new HashSet();
        for(String s : dictionary){
            map.add(s);
        }
        for(String s : queries){
            if(map.contains(s)){
                ans.add(s);
            }else{
                for(String key : map){
                    if(key.length() != s.length())continue;
                    int edits = 0;
                    for(int i=0 ; i<key.length() ; i++){
                        if(key.charAt(i)!=s.charAt(i))edits++;
                        if(edits>2)break;
                    }
                    if(edits<=2){
                        ans.add(s);
                        break;
                    }
                }
            }
        }return ans;
    }
}