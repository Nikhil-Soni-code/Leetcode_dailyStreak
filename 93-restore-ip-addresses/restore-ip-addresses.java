class Solution {
    private void find(List<String> ans,String s,int i,String created){

        if(i==s.length()){
            if(created.split("\\.").length==5){
                ans.add(created.substring(1));
            }return;

        }
        for(int j=i;j<Math.min(s.length(),i+3);j++){
            String newStr = s.substring(i,j+1);
            if(Integer.parseInt(newStr)<=255&&(newStr.length()==1||newStr.charAt(0)!='0')){
                find(ans,s,j+1,created+"."+newStr);

            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList();
        find(ans,s,0,"");
        return ans;
    }
}