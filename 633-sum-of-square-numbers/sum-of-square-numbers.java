class Solution {
    public boolean judgeSquareSum(int c) {
        if(c<=2){
            return true;
        }
        long a = 0,b =(int) Math.pow(c,0.5);
        while(a<=b){
            long sum = (a*a)+(b*b);
            if(sum==c)return true;
            else if(sum<c)a++;
            else b--;
        }
        return false;
    }
}