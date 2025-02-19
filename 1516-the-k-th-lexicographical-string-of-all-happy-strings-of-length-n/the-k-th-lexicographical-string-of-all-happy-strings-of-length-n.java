class Solution {
    int count = 0;
    String ans ="";
    private void create(StringBuilder sbr,int n,int k){
        if(sbr.length()==n){
            count++;
            if(count==k){
                ans = sbr.toString();
            }
            return;
        }
        for(char ch : "abc".toCharArray()){
            if(sbr.length()==0||sbr.charAt(sbr.length()-1)!=ch){
                sbr.append(ch);
                create(sbr,n,k);
                sbr.deleteCharAt(sbr.length()-1);
            }
        }
    }
    public String getHappyString(int n, int k) {
        create(new StringBuilder(),n,k);
        return ans;
    }
}