class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int beg=0,end=letters.length-1;
        while(beg<=end){
            int mid=beg+(end-beg)/2;
            if(target<letters[mid]){
                end=mid-1;
            }
            else{
                beg=mid+1;
            }
        }
        return letters[beg%letters.length];

    }
}