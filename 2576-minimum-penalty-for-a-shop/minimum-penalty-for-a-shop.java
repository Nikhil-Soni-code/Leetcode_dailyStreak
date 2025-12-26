class Solution {
    public int bestClosingTime(String customers) {
        int suffix[] = new int[customers.length()+1];
        int prefix[] = new int[customers.length()+1];



        suffix[suffix.length-1] = 0;
        prefix[0] = 0;

        for(int i=1;i<=customers.length();i++){
            if(customers.charAt(i-1)=='Y'){
                prefix[i] = prefix[i-1];
            }else{
                prefix[i] = prefix[i-1]+1; 
            }
        }

        for(int i=customers.length()-1;i>=0;i--){
            if(customers.charAt(i)=='Y'){
                suffix[i] = suffix[i+1] + 1;
            }else{
                suffix[i] = suffix[i+1];
            }
        }

        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<suffix.length;i++){
            if(suffix[i]+prefix[i] < min){
                minIdx = i;
                min = suffix[i]+prefix[i];
            }
        }return minIdx;
    }
}