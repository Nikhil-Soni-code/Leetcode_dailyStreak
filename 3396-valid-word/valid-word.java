class Solution {
    public boolean isValid(String word) {
        if(word.length()<3){
            return false;
        }
        boolean volCount=false;
        boolean consCount=false;
        for(int i=0;i<word.length();i++){
            if(Character.isLetter(word.charAt(i))){
                
                if((word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u'||word.charAt(i)=='A'||word.charAt(i)=='E'||word.charAt(i)=='I'||word.charAt(i)=='O'||word.charAt(i)=='U')){
                    volCount=true;
                }
                else{
                    consCount=true;
                }
            }
            else{
                if(!Character.isDigit(word.charAt(i))){
                    return false;
            }
        }
        }
        System.out.print(" "+volCount+" "+consCount);
        return volCount&&consCount;

    }
}