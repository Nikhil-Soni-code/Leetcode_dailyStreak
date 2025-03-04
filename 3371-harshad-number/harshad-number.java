class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        if(x<=9){
            return x;
        }
        int sum = 0;
        int num = x;
        while(x!=0){
            sum+=x%10;
            x/=10;
        }
        return (num%sum==0)?sum:-1;
    }
}