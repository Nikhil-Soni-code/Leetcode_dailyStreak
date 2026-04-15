class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        if(words[startIndex].equals(target))return 0;
        int i=(startIndex+1)%words.length;
        int ans = Integer.MAX_VALUE;
        int count = 1;
        while(i!=startIndex){
            if(words[i].equals(target)){
                ans = Math.min(ans,count);
                break;
            }
            count++;
            i = (i+1)%words.length;
        }
        i=(startIndex-1+words.length)%words.length;
        count = 1;
        while(i!=startIndex){
            if(words[i].equals(target)){
                ans = Math.min(ans,count);
                break;
            }
            count++;
            i = (i-1+words.length)%words.length;
        }
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
    }
}