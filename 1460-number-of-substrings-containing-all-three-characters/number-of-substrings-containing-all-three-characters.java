class Solution {
    public int numberOfSubstrings(String s) {
        int start=0,end=0;
        int a=0,b=0,c=0;
        int ans=0;
        while(end<s.length()){
            if(s.charAt(end)=='a'){
                a++;
            }
            else if(s.charAt(end)=='b'){
                b++;
            }      
            else if(s.charAt(end)=='c'){
                c++;
            }
            if(a>=1&&b>=1&&c>=1){
                ans+=s.length()-end;
            }
            while(a>=1 && b>=1 && c>=1){
                if(s.charAt(start)=='a'){
                    a--;
                }
                else if(s.charAt(start)=='b'){
                    b--;
                }      
                else if(s.charAt(start)=='c'){
                    c--;
                }
                start++;
                if(a>=1&&b>=1&&c>=1){
                    ans+=s.length()-end;
                }
            }
            
            end++;
        }
        return ans;
    }
}