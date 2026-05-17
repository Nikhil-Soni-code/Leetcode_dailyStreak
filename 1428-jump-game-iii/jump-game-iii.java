class Solution {
    private boolean checkZero(int[] arr){
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]==0)return true;
        }return false;
    }
    private boolean reachZero(int[] arr,int i,boolean[] visited){
        if(i>=arr.length)return false;
        if(i<0)return false;
        if(visited[i])return false;
        if(arr[i]==0)return true;

        visited[i] = true;
        return reachZero(arr,i-arr[i],visited) || reachZero(arr,i+arr[i],visited);
    }
    public boolean canReach(int[] arr, int start) {
        if(!checkZero(arr))return false;
        boolean[] visited = new boolean[arr.length];
        return reachZero(arr,start,visited);
    }
}