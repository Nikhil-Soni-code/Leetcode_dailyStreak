class Solution {
    private int convert(String str){
        String num = ""+str.charAt(0)+str.charAt(1)+str.charAt(3)+str.charAt(4);
        return Integer.parseInt(num);
    }
    public boolean haveConflict(String[] event1, String[] event2) {
        int event1Start = convert(event1[0]);
        int event1End = convert(event1[1]);
        int event2Start = convert(event2[0]);
        int event2End = convert(event2[1]);

        if(event2Start<=event1End&&event2Start>=event1Start)return true;
        if(event1Start<=event2End&&event1Start>=event2Start)return true;
        if(event1Start>=event2Start&&event1End<=event2End)return true;
        if(event2Start>=event1Start&&event2End<=event1End)return true;
        return false;



    }
}