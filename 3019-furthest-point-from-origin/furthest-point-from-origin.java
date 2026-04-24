class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int Lcount = 0;
        int Rcount = 0;
        for(char ch : moves.toCharArray()){
            if(ch=='L')Lcount++;
            if(ch=='R')Rcount++;
        }
        
        int ans = 0;
        int dist=0;
        for(char ch : moves.toCharArray()){
            if(ch=='L'){
                dist--;
            }
            if(ch=='R'){
                dist++;
            }
            if(ch=='_'){
                if(Lcount>Rcount){
                    dist--;
                }else{
                    dist++;
                }
            }
        }
        return Math.abs(dist);
    }
}