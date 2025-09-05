class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap();
        int i=0,j=0,maxAns = 0;
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(map.get(s.charAt(j))>1){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            maxAns = Math.max(maxAns,j-i+1);
            j++;
        }return maxAns;
    }
}