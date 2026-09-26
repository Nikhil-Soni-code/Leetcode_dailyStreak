class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder();
        HashMap<String,String> map = new HashMap();
        for(List<String> list : knowledge){
            map.put(list.get(0),list.get(1));
        }
        String prev = "";
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                i++;
                while(i<s.length() && s.charAt(i)!=')'){
                    prev += s.charAt(i);
                    i++;
                }
                if(map.containsKey(prev)){
                    ans.append(map.get(prev));
                }else{
                    ans.append("?");
                }
                prev = "";
                i++;
            }
            else{
                while(i<s.length() && s.charAt(i)!='('){
                    prev += s.charAt(i);
                    i++;
                }
                ans.append(prev);
                prev = "";
            }
        }
        return ans.toString();
    }
}