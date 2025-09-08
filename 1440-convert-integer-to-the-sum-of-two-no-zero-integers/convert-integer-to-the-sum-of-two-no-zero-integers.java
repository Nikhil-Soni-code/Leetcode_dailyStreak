class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i=1;i<=n-1;i++){
            String num1 = ""+i;
            String num2 = ""+(n-i);
            if(num1.indexOf('0')==-1 && num2.indexOf('0')==-1){
                ans[0] = i;
                ans[1] = n-i;
                break;
            }
        }
        
        return ans;
    }
}