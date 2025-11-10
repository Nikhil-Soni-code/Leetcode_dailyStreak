class Solution {
    private int[] nge(int[] height){
        int[] next = new int[height.length];
        next[height.length-1] = -1;
        for(int i=height.length-2;i>=0;i--){
            next[i] = Math.max(next[i+1],height[i+1]);
        }
        return next;
    }
    private int[] pge(int[] height){
        int[] prev = new int[height.length];
        prev[0] = -1;
        for(int i=1;i<height.length;i++){
            prev[i] = Math.max(prev[i-1],height[i-1]);
        }
        return prev;
    }
    public int trap(int[] height) {
        int[] next = nge(height);
        for(int i=0;i<next.length;i++){
            System.out.print(next[i]+" ");
        }
        int[] prev = pge(height);
        int water = 0;
        for(int i=0;i<height.length;i++){
            int area = Math.min(next[i],prev[i])-height[i];
            if(area>0){
                
                water+=area;
            }
        }
        return water;

    }
}