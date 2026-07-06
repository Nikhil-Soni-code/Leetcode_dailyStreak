class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0])return b[1]-a[1];
            return a[0]-b[0];
        });
        int[] prev = intervals[0];
        int count = 1;
        for(int i=1 ; i<intervals.length ; i++){
            if(intervals[i][0]>=prev[0] && intervals[i][1]<=prev[1]){

                continue;
            }
            else {
                prev = new int[]{intervals[i][0],intervals[i][1]};
                count++;
            }

        }
        return count;
    }
}