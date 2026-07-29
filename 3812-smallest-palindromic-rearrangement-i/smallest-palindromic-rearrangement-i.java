class Solution {
    public String smallestPalindrome(String s) {
        int[] hash = new int[26];
        for(char ch : s.toCharArray()){
            hash[ch-'a']++;
        }
        StringBuilder ans = new StringBuilder();
        char extraChar = ' ';
        for(int i=0 ; i<26 ; i++){
            if(hash[i]%2==1){
                extraChar = (char)(i+'a');
                hash[i]--;
            }
            if(hash[i]!=0){
                char ch = (char)(i+'a');
                for(int j=1 ; j<=(hash[i]/2) ; j++){
                    // System.out.println(ch);
                    ans.append(ch);
                }
            }
        }
        StringBuilder finalAns = new StringBuilder(ans);
        if(extraChar!= ' '){
            finalAns.append(extraChar);
        }
        finalAns.append(new StringBuilder(ans).reverse());
        
        return finalAns.toString();
        

        
    }
}