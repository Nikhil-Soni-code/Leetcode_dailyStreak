class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(map.containsKey(i-j)){
                    map.get(i-j).add(mat[i][j]);
                }else{
                    PriorityQueue<Integer> pq = new PriorityQueue();
                    pq.add(mat[i][j]);
                    map.put(i-j,pq);
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mat[i][j] = (int)map.get(i-j).poll();
            }
        }return mat;
    }
}