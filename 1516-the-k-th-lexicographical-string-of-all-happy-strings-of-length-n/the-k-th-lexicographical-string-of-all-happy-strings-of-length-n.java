class Solution {
    int count = 0;
    private String create(StringBuilder sbr,int n,int k){
        if(sbr.length()==n){
            count++;
            if(count==k){
                return sbr.toString();
            }
            return "";
        }
        for(Character ch : "abc".toCharArray()){
            if(sbr.length()==0||sbr.charAt(sbr.length()-1)!=ch){
                sbr.append(ch);
                String ans = create(sbr,n,k);
                if(ans!=""){
                    return ans;
                }
                sbr.deleteCharAt(sbr.length()-1);
            }
        }
        return "";
    }
    public String getHappyString(int n, int k) {
        return create(new StringBuilder(),n,k);
    }
}