class Solution {
    private void generate(List<String> ans,StringBuilder sbr,int openCount,int closeCount,int n){
        if(openCount==n&&closeCount==n){
            ans.add(sbr.toString());
            return;
        }
        if(openCount<n){
            sbr.append('(');
            generate(ans,sbr,openCount+1,closeCount,n);
            sbr.deleteCharAt(sbr.length()-1);
        }
        if(closeCount<n&&closeCount<openCount){
            sbr.append(')');
            generate(ans,sbr,openCount,closeCount+1,n);
            sbr.deleteCharAt(sbr.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        StringBuilder sbr = new StringBuilder();
        sbr.append("(");
        generate(ans,sbr,1,0,n);
        return ans;
    }
}