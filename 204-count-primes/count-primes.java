class Solution {
    public int countPrimes(int n) {
        // if(n<)
        boolean answer[] = new boolean[n];
        Arrays.fill(answer,false);
        markPrimes(answer,n);
        int count = 0;
        for(int i=2;i<answer.length;i++){
            if(!answer[i])count++;
        }return count;
    }
    private void markPrimes(boolean[] answer,int n){
        for(int i=2;i*i<=n;i++){
            if(!answer[i]){
                for(int j=i*2;j<n;j+=i){
                    answer[j] = true;
                }
            }
        }
    }
}