class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] curr = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(curr[1]>=intervals[i][0]){
                curr[1] = Math.max(curr[1],intervals[i][1]);
            }else{
                ans.add(curr);
                curr = intervals[i];
            }
        }
        ans.add(curr);
        int[][]finalAns = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            finalAns[i] = ans.get(i);
        }
        return finalAns;

    }
}