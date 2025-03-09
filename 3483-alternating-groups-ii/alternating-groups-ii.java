class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int start = 0;
        int end = 1;
        int n = colors.length;
        int currLength = 0;
        int ans = 0;
        while(start<n){
            if(end==0){
                if(colors[end]==colors[n-1]){
                    break;
                }
            }
            else if(colors[end-1]==colors[end]){
                if(start<end){
                    start = end;
                }else{
                    break;
                }
            }
            if(start<=end){
                currLength = end-start+1;
            }
            else{
                currLength = n-start+(end+1);
            }
            if(currLength == k){
                ans++;
                start++;
            }
            end = (end+1)%n;
        }
        return ans;
    }
}