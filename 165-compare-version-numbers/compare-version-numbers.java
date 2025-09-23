class Solution {
    public int compareVersion(String version1, String version2) {
        String[] charV1 = version1.split("\\.");
        String[] charV2 = version2.split("\\.");
        int i=0,j=0;
        while(i<charV1.length&&j<charV2.length){
            int num1 = Integer.parseInt(charV1[i]);
            int num2 = Integer.parseInt(charV2[j]);

            if(num1==num2){
                i++;j++;
            }
            else if(num1<num2){
                return -1;
            }else{
                return 1;
            }
        }
        while(i<charV1.length){
            int num1 = Integer.parseInt(charV1[i]);
            if(num1==0)i++;
            else return 1;
        }
        while(j<charV2.length){
            int num2 = Integer.parseInt(charV2[j]);
            if(num2==0)j++;
            else return -1;
        }return 0;


    }
}