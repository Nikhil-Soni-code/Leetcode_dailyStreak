class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int idx=-1;
        int minLength = Integer.MAX_VALUE;
        int count=0;
        int start=0;
        int end=0;
        while(end<s.length()){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count++;
                }
            }
            if(count==map.size()){

                while(start<=end&&count==map.size()){
                    ch = s.charAt(start);
                    if(map.containsKey(ch)){
                        map.put(ch,map.get(ch)+1);

                        if(map.get(ch)>0){
                            count--;
                        }
                        if(minLength>end-start+1){
                            minLength = end-start+1;
                            idx=start;
                        }
                    }
                    start++;
                }

            }
            end++;
        }
        return (idx==-1)?"":s.substring(idx,idx+minLength);

    }
}