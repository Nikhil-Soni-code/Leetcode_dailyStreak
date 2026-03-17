class Solution {
    public boolean hasAllCodes(String s, int k) {
    
        HashSet<String> set = new HashSet();
        StringBuilder sbr = new StringBuilder();
        for(int i=0 ; i<Math.min(k,s.length()) ; i++){
            sbr.append(s.charAt(i));
        }
        set.add(sbr.toString());
        for(int i=k ; i<s.length() ; i++){
            sbr.deleteCharAt(0);
            sbr.append(s.charAt(i));
            set.add(sbr.toString());
        }
        return set.size() == Math.pow(2,k);
    }
}