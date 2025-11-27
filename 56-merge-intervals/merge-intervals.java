class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] interval = intervals[0];
        List<int[]> ans = new ArrayList();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=interval[1]){
                interval[1] = Math.max(interval[1],intervals[i][1]);
            }else{
                ans.add(interval);
                interval = intervals[i];
            }
        }
        ans.add(interval);
        int i=0;
        int[][] a = new int[ans.size()][2];
        for(int[]b:ans){
            a[i++] = b;
        }return a;
        
    }
}