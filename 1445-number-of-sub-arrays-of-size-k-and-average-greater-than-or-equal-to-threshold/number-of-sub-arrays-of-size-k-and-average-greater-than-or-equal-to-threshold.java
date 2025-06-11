class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int i=0,j=k;
        if(sum/k>=threshold){
            count++;
        }
        while(j<arr.length){
            sum-=arr[i++];
            sum+=arr[j++];
            if(sum/k>=threshold){
                count++;
            }
        }
        return count;
    }
}