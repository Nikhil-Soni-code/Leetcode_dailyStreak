class Solution {
    private StringBuilder justify(StringBuilder r,int maxWidth){
        int remWidth = maxWidth-r.length();
        String[] temp = r.toString().split("\\s+");
        int gap = temp.length-1;
        if(gap<=0){
            for(int i=0;i<remWidth;i++){
                r.append(" ");
            }
            return r;
        }
        int spaces = remWidth/gap;
        int extraSpace = remWidth%gap;
        StringBuilder sbr = new StringBuilder();
        for(int i=0;i<temp.length-1;i++){
            sbr.append(temp[i]);
            sbr.append(" ");
            for(int j=0;j<spaces;j++){
                sbr.append(" ");
            }
            if(extraSpace>0){
                sbr.append(" ");
                extraSpace--;
            }
        }
        sbr.append(temp[temp.length-1]);
        return sbr;
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList();
        StringBuilder result = new StringBuilder();
        for(String word:words){
            if(result.length()==0){
                result.append(word);
            }
            else if(result.length()+word.length()<maxWidth){
                result.append(" ");
                result.append(word);
            }else{
                result = justify(result,maxWidth);
                ans.add(result.toString());
                result = new StringBuilder(word);
            }
        }
        while(result.length()<maxWidth){
            result.append(" ");
        }
        ans.add(result.toString());
        return ans;
    }
}