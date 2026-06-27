class Solution {
    private void mergeSort(int[] nums,int beg,int end){
        if(beg<end){
            int mid = beg+(end-beg)/2;
            mergeSort(nums,beg,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,beg,mid,end);
        }
    }
    private void merge(int[] nums,int beg,int mid , int end){
        int[] left = new int[mid-beg+1];
        int[] right = new int[end-mid];
        int k = 0;
        for(int i=beg ; i<=mid ; i++){
            left[k++] = nums[i];
        }
        k=0;
        for(int j=mid+1 ; j<=end ; j++){
            right[k++] = nums[j];
        }
        k=0;
        int[] merged = new int[end-beg+1];
        int i=0, j=0 ; 
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                merged[k++] = left[i++];
            }else{
                merged[k++] = right[j++];
            }
        }
        while(i<left.length){
            merged[k++] = left[i++];
        }
        while(j<right.length){
            merged[k++] = right[j++];
        }
        k = beg;
        for(i=0 ; i<merged.length ; i++){
            nums[k++] = merged[i];
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}