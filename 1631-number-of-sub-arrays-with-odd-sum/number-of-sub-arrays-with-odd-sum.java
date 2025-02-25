class Solution {
    public int numOfSubarrays(int[] arr) {
        int evenCount=1;
        int oddCount=0;
        int ans = 0;
        int prefixSum=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(prefixSum%2==0){
                evenCount++;
                ans=(ans+oddCount)%1000000007;

            }
            else{
                oddCount++;
                ans=(ans+evenCount)%1000000007;
            }
        }
        return ans;
    }
}