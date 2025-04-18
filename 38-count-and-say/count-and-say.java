class Solution {
    private String count(String str){
        char curr = str.charAt(0);
        int count = 0;
        StringBuilder countString = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(curr==str.charAt(i)){
                count++;
            }
            else{
                countString.append(count);
                countString.append(curr);
                curr = str.charAt(i);
                count = 1;
            }
        }
        countString.append(count);
        countString.append(curr);
        return countString.toString();
    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String prev = countAndSay(n-1);
        return count(prev);
    }
}