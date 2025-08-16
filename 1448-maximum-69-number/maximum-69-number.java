class Solution {
    public int maximum69Number (int num) {
        int ans = 0;
        String n = ""+num;
        int flag = 1;
        for(int i=0;i<n.length();i++){
            if(n.charAt(i)=='6'&&flag==1){
                ans = ans*10+9;
                flag=0;

            }
            else{
                ans = ans*10+(n.charAt(i)-'0');
            }
        }
        return ans;
    }
}