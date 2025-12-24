class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for(int i=0;i<apple.length;i++){
            totalApples+=apple[i];
        }
        Arrays.sort(capacity);
        int count = 0;
        for(int i=capacity.length-1;i>=0;i--){
            totalApples-=capacity[i];
            count++;
            if(totalApples<=0)return count;
        }return -1;
    }
}