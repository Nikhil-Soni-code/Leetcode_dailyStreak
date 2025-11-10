class Solution {
    private void generate(List<String> ans , StringBuilder subAns,int open,int close){
        if(open==0 && close==0){
            ans.add(new String(subAns));
            return;
        }
        if(open>0){
            subAns.append('(');
            generate(ans,subAns,open-1,close);
            subAns.deleteCharAt(subAns.length()-1);
        }
        if(close>0 && open<close){
            subAns.append(')');
            generate(ans,subAns,open,close-1);
            subAns.deleteCharAt(subAns.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        generate(ans,new StringBuilder(),n,n);
        return ans;
    }
}