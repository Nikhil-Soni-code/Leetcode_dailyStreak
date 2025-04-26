class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        list.add(intervals[0]);
        int idx = 0;
        for(int i=1;i<intervals.length;i++){
            if(list.get(idx)[1]>=intervals[i][0]){
                int[] a = list.get(idx);
                a[1] = Math.max(intervals[i][1],a[1]);
                list.remove(idx);
                list.add(a);

            }
            else{
                list.add(intervals[i]);
                idx++;
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;

    }
}