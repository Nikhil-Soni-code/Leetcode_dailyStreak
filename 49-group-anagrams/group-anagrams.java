class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList();
        HashMap<String,List<String>> map = new HashMap();
        for(int i=0 ; i<strs.length ; i++){

            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(map.containsKey(sorted)){
                map.get(sorted).add(strs[i]);
            }else{
                List<String> str = new ArrayList();
                str.add(strs[i]);
                map.put(sorted,str);
            }
        }
        for(String key : map.keySet()){
            ans.add(new ArrayList(map.get(key)));
        }
        return ans;

        
    }
}