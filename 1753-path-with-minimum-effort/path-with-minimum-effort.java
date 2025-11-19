class Solution {
    public int minimumEffortPath(int[][] heights) {
        if(heights.length==1 && heights[0].length==1)return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        int[][] distance = new int[heights.length][heights[0].length];
        for(int[]a:distance){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int i = cell[1];
            int j = cell[2];
            int effort = cell[0];
            if(i>0 && distance[i-1][j] > Math.max(effort,Math.abs(heights[i][j]-heights[i-1][j]))){
                distance[i-1][j] = Math.max(effort,Math.abs(heights[i][j]-heights[i-1][j]));
                pq.add(new int[]{distance[i-1][j],i-1,j});
            }
            if(j>0 && distance[i][j-1] > Math.max(effort,Math.abs(heights[i][j]-heights[i][j-1]))){
                distance[i][j-1] = Math.max(effort,Math.abs(heights[i][j]-heights[i][j-1]));
                pq.add(new int[]{distance[i][j-1],i,j-1});
            }
            if(i<heights.length-1 && distance[i+1][j] > Math.max(effort,Math.abs(heights[i][j]-heights[i+1][j]))){
                distance[i+1][j] = Math.max(effort,Math.abs(heights[i][j]-heights[i+1][j]));
                pq.add(new int[]{distance[i+1][j],i+1,j});
            }
            if(j<heights[0].length-1 && distance[i][j+1] > Math.max(effort,Math.abs(heights[i][j]-heights[i][j+1]))){
                distance[i][j+1] = Math.max(effort,Math.abs(heights[i][j]-heights[i][j+1]));
                pq.add(new int[]{distance[i][j+1],i,j+1});
            }
        }
        return distance[heights.length-1][heights[0].length-1];
        
    }
}