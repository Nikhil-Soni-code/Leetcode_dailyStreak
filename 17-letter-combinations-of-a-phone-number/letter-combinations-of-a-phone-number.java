class Solution {
    HashMap<Character,String> map = new HashMap();
    private void generate(List<String> ans,StringBuilder sbr,String digits,int idx){
        if(idx==digits.length()){
            ans.add(sbr.toString());
            return;
        }
        String letters = map.get(digits.charAt(idx));
        for(int i=0;i<letters.length();i++){
            sbr.append(letters.charAt(i));
            generate(ans,sbr,digits,idx+1);
            sbr.deleteCharAt(sbr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList();
        if(digits.length()==0){
            return ans;
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        generate(ans,new StringBuilder(),digits,0);
        return ans;
    }
}