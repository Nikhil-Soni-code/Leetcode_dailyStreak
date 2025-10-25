class Solution {
    public int totalMoney(int n) {
        int weeks = (int)Math.ceil(n/7.0);
        // return weeks;
        int remaining = (n%7==0)?7:n%7;
        int money = 0;
        int i=1;
        for(i=1;i<weeks;i++){
            money+=(7*(2*i+6))/2;
        }
        money+=remaining*(2*i+(remaining-1))/2;
        return money;

    }
}