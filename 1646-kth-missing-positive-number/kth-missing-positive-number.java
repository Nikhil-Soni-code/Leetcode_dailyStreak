class Solution {
    public int findKthPositive(int[] arr, int k) {
        int beg = 0;
        int end = arr.length-1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            int noOfMissingElements = arr[mid]-(mid+1);
            if(noOfMissingElements>=k){
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return beg+k;
    }
}