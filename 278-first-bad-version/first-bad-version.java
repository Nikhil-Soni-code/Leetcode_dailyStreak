/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int beg = 1,end = n;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(isBadVersion(mid)){
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return beg;
    }
}