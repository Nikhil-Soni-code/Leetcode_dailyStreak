class Solution {
    public char kthCharacter(int k) {
        StringBuilder sbr = new StringBuilder("a");
        while(sbr.length()<k+1){
            int length = sbr.length();
            for(int i=0;i<length;i++){
                sbr.append((char)(sbr.charAt(i)+1));
            }
        }
        System.out.print(sbr.toString());
        return sbr.charAt(k-1);
    }
}