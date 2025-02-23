class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
            HashMap<Character,Integer> map = new HashMap(); 
        int maxOccur = -1;
        int maxLength=0;
        int start=0;
        int end=0;
        while(end<answerKey.length()){
            map.put(answerKey.charAt(end),map.getOrDefault(answerKey.charAt(end),0)+1);
            maxOccur = Math.max(maxOccur,map.get(answerKey.charAt(end)));
            int distinctElements = (end-start+1)-maxOccur;
            if(distinctElements>k){
                while((end-start+1-maxOccur)>k){
                    map.put(answerKey.charAt(start),map.get(answerKey.charAt(start))-1);
                    start++;
                }
            }
            maxLength = Math.max(maxLength,end-start);
            end++;
        }
            maxLength = Math.max(maxLength,end-start);
return maxLength;

    }
}