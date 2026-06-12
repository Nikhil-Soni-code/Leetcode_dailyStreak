class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap();

        for(int i=0 ; i<strs.length ; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            System.out.print(sorted);
            if(map.containsKey(sorted)){
                map.get(sorted).add(strs[i]);
            }else{
                List<String> list = new ArrayList();
                list.add(strs[i]);
                map.put(sorted,list);
            }
        }
        List<List<String>> ans = new ArrayList();
        for(String s : map.keySet()){
            List<String> subList = new ArrayList();
            for(String str: map.get(s)){
                subList.add(str);
            }
            ans.add(new ArrayList(subList));
        }
        return ans;
    }
}