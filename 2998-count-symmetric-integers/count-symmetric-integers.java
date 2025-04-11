class Solution {
    private boolean isSymmetric(int num,int length){
        int l = length/2;
        int sum1 = 0;
        while(l!=0){
            sum1+=num%10;
            num/=10;
            l--;
        }
        l = length/2;
        int sum2 = 0;
        while(l!=0){
            sum2+=num%10;
            num/=10;
            l--;
        }
        return sum1==sum2;


    }
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i=low;i<=high;i++){
            int length = (int)(Math.log10(i))+1;

            if(length%2==0&&isSymmetric(i,length)){
                count++;
            }
        }
        return count;
    }
}