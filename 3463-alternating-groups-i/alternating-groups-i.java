class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count=0;
        if(colors[0]!=colors[1]&&colors[0]!=colors[n-1])count++;
        for(int i=1;i<n;i++){
            if(colors[i-1]!=colors[i]&&colors[i]!=colors[(i+1)%n]){
                count++;
            }
        }
        return count;
    }
}