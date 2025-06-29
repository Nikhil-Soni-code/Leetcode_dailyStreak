class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList();
        HashMap<String,Integer> map = new HashMap();
        for(int i=0;i<=s.length()-10;i++){
            String str = s.substring(i,i+10);
            if(map.containsKey(str)&&map.get(str)==1){
                ans.add(str);
            }
                            map.put(str,map.getOrDefault(str,0)+1);

        }
        return ans;
    }
}