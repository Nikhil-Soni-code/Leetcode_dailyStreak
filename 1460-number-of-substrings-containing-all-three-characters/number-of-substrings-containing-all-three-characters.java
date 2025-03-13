class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap();
        int start = 0;
        int end = 0;
        int ans = 0;
        int n = s.length();
        while(end<n){
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);
            if(map.size()==3){
                while(map.size()==3){
                    ans+=n-end;
                    map.put(s.charAt(start),map.get(s.charAt(start))-1);
                    if(map.get(s.charAt(start))==0){
                        map.remove(s.charAt(start));
                    }start++;
                }
            }end++;
        }return ans;
    }
}