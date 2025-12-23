class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int[] maxSuffix = new int[events.length];
        maxSuffix[events.length-1] = events[events.length-1][2];
        for(int i=events.length-2;i>=0;i--)maxSuffix[i] = Math.max(maxSuffix[i+1],events[i][2]);
        int maxSum = 0;
        for(int i=0;i<events.length;i++){
            int sum = events[i][2]+find(events,events[i][1],i,maxSuffix);
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
    private int find(int[][] events,int lastEnd,int i,int[]maxSuffix){
        int max = 0;
        int beg = i+1,end = events.length-1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(events[mid][0]<=lastEnd)beg = mid+1;
            else if(events[mid][1]>lastEnd)end = mid-1;
        }
        if(beg==events.length)return 0;
        return maxSuffix[beg];

    }
}