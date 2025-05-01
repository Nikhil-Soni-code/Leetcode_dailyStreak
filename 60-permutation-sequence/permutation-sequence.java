class Solution {
    String ans = "";
    int k = 0;
    private void permute(StringBuilder pro,StringBuilder unPro){
        if(unPro.length()==0||k==0){
            k--;
            if(k==0){
                ans = pro.toString();
            }
            return; 

        }
        for(int i=0;i<unPro.length();i++){
            if(ans==""){
                pro.append(unPro.charAt(i));
                char temp = unPro.charAt(i);
                unPro.deleteCharAt(i);

                permute(pro,unPro);

                pro.deleteCharAt(pro.length()-1);
                unPro.insert(i,temp);
            }
        }
    } 
    public String getPermutation(int n, int k) {
        StringBuilder sbr = new StringBuilder();
        for(int i=1;i<=n;i++){
            sbr.append(i);
        }
        this.k = k;
        permute(new StringBuilder(),sbr);
        return ans;

    }
}