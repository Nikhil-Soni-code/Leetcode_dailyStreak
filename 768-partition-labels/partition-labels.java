class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0 ; i<s.length() ; i++){
            map.put(s.charAt(i),i);
        }
        int farPoint = -1;
        int prev = -1;
        List<Integer> ans = new ArrayList();
        for(int i=0 ; i<s.length() ; i++){
            farPoint = Math.max(farPoint,map.get(s.charAt(i)));
            if(i==farPoint){
                ans.add(i-prev);
                prev = i;
            }
        }
        return ans;
    }
}