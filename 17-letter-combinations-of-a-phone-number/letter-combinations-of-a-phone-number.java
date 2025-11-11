class Solution {
    private void combo(List<String> ans,String digits,int i,HashMap<Character,String> map,StringBuilder sbr){
        if(i==digits.length()){
            ans.add(sbr.toString());
            return;
        }
        String letters = map.get(digits.charAt(i));
        for(int idx=0;idx<letters.length();idx++){
            sbr.append(letters.charAt(idx));
            combo(ans,digits,i+1,map,sbr);
            sbr.deleteCharAt(sbr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans = new ArrayList();
        combo(ans,digits,0,map,new StringBuilder());
        return ans;

    }
}