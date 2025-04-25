class Solution {
    private List<int[]> insertInterval(int[][] intervals, int[] newInterval){
        List<int[]> list = new ArrayList();
        int i=0;
        while(i<intervals.length&&intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        while(i<intervals.length&&intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        for(int j=i;j<intervals.length;j++){
            list.add(intervals[j]);
        }
        return list;

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = insertInterval(intervals,newInterval);
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);

        }
        return ans;
    }

}