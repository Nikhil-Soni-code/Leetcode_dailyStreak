class Solution {
    private int binarySearch(long a,int[] arr,long b){
        int beg = 0,end = arr.length-1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(arr[mid]*a>=b){
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return arr.length-beg;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for(int i=0;i<spells.length;i++){

            ans[i] = binarySearch(spells[i],potions,success);
        }
        return ans;
    }
}