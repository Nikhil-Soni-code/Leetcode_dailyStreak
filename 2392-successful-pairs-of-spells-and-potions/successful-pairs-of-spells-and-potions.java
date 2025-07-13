class Solution {
    private int binarySearch(int[] a,double target){
        int beg = 0;
        int end = a.length-1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(a[mid]>=target){
                end = mid-1;
            }
            else{
                beg = mid+1;
            }
        }
        return a.length-beg;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            double minValue = 1.0*success/spells[i];
            pairs[i] = binarySearch(potions,minValue);

        }
        return pairs;
    }
}