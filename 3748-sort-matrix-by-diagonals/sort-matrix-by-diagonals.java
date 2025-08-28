class Solution {
    public int[][] sortMatrix(int[][] grid) {
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(map.containsKey(i-j)){
                    map.get(i-j).add(grid[i][j]);
                }else{
                    if(i-j>=0){
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                        pq.add(grid[i][j]);
                        map.put(i-j,pq);
                    }else{
                        PriorityQueue<Integer> pq = new PriorityQueue<>();
                        pq.add(grid[i][j]);
                        map.put(i-j,pq);
                    }
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j] = map.get(i-j).poll();
            }
        }return grid;
    }
}