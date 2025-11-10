class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] interval =  intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=interval[1]){
                interval[1] = Math.max(intervals[i][1],interval[1]);
            }else{
                merged.add(interval);
                interval = intervals[i];
            }
        }
        merged.add(interval);
        int[][] ans = new int[merged.size()][2];
        int idx = 0;
        for(int[]a:merged){
            ans[idx++] = a;
        }return ans;
    }
}