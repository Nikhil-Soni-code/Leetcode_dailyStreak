class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap();
               if(s.length()==0)return 0;
        if(s.length()==1)return 1;
        s = s.trim();
        if(s.length()==0)return 1;
        int count = 0,i=0;
        for(int j=0;j<s.length();j++){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(i<j&&map.get(s.charAt(j))>1){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            count = Math.max(count,j-i+1);
        }return count;
    }
}