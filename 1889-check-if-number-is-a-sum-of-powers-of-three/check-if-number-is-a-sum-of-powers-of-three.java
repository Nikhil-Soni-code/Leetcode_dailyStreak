class Solution {
    public boolean checkPowersOfThree(int n) {
        for(int i=14;i>=0;i--){
            int no = (int)Math.pow(3,i);
            if(n-no>=0){
                n=n-no;
            }
            if(n==0){
                return true;
            }
        }
        return false;
    }
}