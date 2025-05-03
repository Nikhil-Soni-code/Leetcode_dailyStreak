class Solution {
    private void markPrimes(int[] mark){
        int n = mark.length;
        mark[0] = -1;
        mark[1] = -1;
        for(int i=2;i*i<=n;i++){
            if(mark[i]==0){ 
                for(int j=i*2;j<n;j+=i){
                    mark[j] = -1;
                }
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        int[] mark = new int[right+1];
        markPrimes(mark);
        List<Integer> primes = new ArrayList();
        for(int i=left;i<=right;i++){
            if(mark[i]==0){
                primes.add(i);
            }
        }
        int minDiff = Integer.MAX_VALUE;
        int minNum1 = -1;
        int minNum2 = -1;
        System.out.println(primes);
        for(int i=1;i<primes.size();i++){
            if(minDiff>(primes.get(i)-primes.get(i-1))){
                minNum1 = primes.get(i-1);
                minNum2 = primes.get(i);
                minDiff = minNum2-minNum1;
            }
        }
        return new int[]{minNum1,minNum2};
    }
}