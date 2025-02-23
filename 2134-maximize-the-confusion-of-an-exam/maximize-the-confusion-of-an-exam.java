class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxOccur = -1;
        int maxLength=0;
        int tcount=0;
        int fcount=0;

        int start=0;
        int end=0;
        while(end<answerKey.length()){
            if(answerKey.charAt(end)=='T'){
                tcount++;
            maxOccur = Math.max(maxOccur,tcount);

            }
            else{
                fcount++;
            maxOccur = Math.max(maxOccur,fcount);
            }
            int distinctElements = (end-start+1)-maxOccur;
            if(distinctElements>k){
                while((end-start+1-maxOccur)>k){
                    if(answerKey.charAt(start)=='T'){
                        tcount--;
                    }else{
                        fcount--;
                    }
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