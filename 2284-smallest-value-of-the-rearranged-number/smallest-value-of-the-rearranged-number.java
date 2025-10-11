class Solution {
    public long smallestNumber(long num) {
        if(num==0)return 0;
        boolean isPositive = (num>0)?true:false;
        num = Math.abs(num);
        long[] hash = new long[10];
        while(num!=0){
            hash[(int)(num%10)]++;
            num/=10;
        }
        long ans = 0;
        if(isPositive){
            int found = 0;
            int i=1;
            while(i<=9){
                if(hash[i]>0){
                        ans=ans*10+i;
                        hash[i]--;
                    break;
                }
                i++;
            }
            while(hash[0]!=0){
                ans = ans*10+0;
                hash[0]--;
            }

            for(int j=i;j<=9;j++){
                while(hash[j]>0){
                    ans=ans*10+j;
                    hash[j]--;
                }
            }
            return ans;
        }else{
            for(int i=9;i>=0;i--){
                while(hash[i]>0){
                    ans=ans*10+i;
                    hash[i]--;
                }
            }
            return -1*ans;
        }

    }
}