class Solution {
    private int count(int n , int i){
        if(n==0){
            return 1;

        }
        int counter = 0;
        if(i==0)
        {
            counter+=count(n-1,0);
            counter+=count(n-1,1);
            counter+=count(n-1,2);
            counter+=count(n-1,3);
            counter+=count(n-1,4);
        }
                if(i==1)
        {
            counter+=count(n-1,1);
            counter+=count(n-1,2);
            counter+=count(n-1,3);
            counter+=count(n-1,4);
        }
                if(i==2)
        {
            counter+=count(n-1,2);
            counter+=count(n-1,3);
            counter+=count(n-1,4);
        }
                if(i==3)
        {
            counter+=count(n-1,3);
            counter+=count(n-1,4);
        }
                if(i==4)
        {
            counter+=count(n-1,4);
        }
        return counter;
    }
    public int countVowelStrings(int n) {
        return count(n,0);
    }
}