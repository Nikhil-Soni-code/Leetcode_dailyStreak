class Solution {
    private String construct(String pattern,StringBuilder sbr,int idx,int n){
        if(sbr.length()==n){
            return sbr.toString();
        }

        if(idx==-1||pattern.charAt(idx)=='I'){
            int prev=1;
            if(idx>-1){
                prev = sbr.charAt(sbr.length()-1)-'0';
            }
            for(int i = prev;i<=9;i++){
                if(isValid(i,sbr)){
                    sbr.append(i);
                    String ans = construct(pattern,sbr,idx+1,n);
                    if(ans!=""){
                        return ans;
                    }
                    sbr.deleteCharAt(sbr.length()-1);
                }
            }
        }else{  
            int prev = sbr.charAt(sbr.length()-1)-'0';
            for(int i = prev;i>0;i--){
                if(isValid(i,sbr)){
                    sbr.append(i);
                    String ans = construct(pattern,sbr,idx+1,n);
                    if(ans!=""){
                        return ans;
                    }
                    sbr.deleteCharAt(sbr.length()-1);
                }
            }
        }
        return "";
    }
    private boolean isValid(int digit,StringBuilder sbr){
        for(int i=0;i<sbr.length();i++){
            if(sbr.charAt(i)-'0'==digit){
                return false;
            }
        }
        return true;
    }
    public String smallestNumber(String pattern) {
        return construct(pattern,new StringBuilder(),-1,pattern.length()+1);
    }
}