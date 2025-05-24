class Solution {
    public int maxSubstrings(String word) {
        List<int[]> intervals = new ArrayList();
        for(int i=0;i<word.length();i++){
            for(int j=i+3;j<word.length();j++){
                if(word.charAt(i)==word.charAt(j)){
                    intervals.add(new int[]{i,j});break;
                }
            }
        }
        Collections.sort(intervals,(a,b)->a[1]-b[1]);
        int prev = -1;
        int count = 0;
        for(int i=0;i<intervals.size();i++){
            if(intervals.get(i)[0]>prev){
                prev = intervals.get(i)[1];
                count++;
            }
        }return count;
    }
}