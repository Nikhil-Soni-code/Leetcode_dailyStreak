class Solution {
    private int makingTopsSame(int[] tops,int[] bottoms,int rotations,int domino){
        int ans = Integer.MAX_VALUE;
        int rot = rotations;
        boolean flag = true;
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=domino&&bottoms[i]!=domino){
                flag = false;
            }
        }return -1;
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count1 = 0; //to make everyone tops elements equal to tops[0]
        int count2 = 0; //to make everyone tops elements equal to bottoms[0]
        int count3 = 0; //to make everyone bottoms elements equal to tops[0]
        int count4 = 0; //to make everyone bottoms elements equal to bottoms[0]
        int domino1 = tops[0];
        int domino2 = bottoms[0];

        for(int i=0;i<tops.length;i++){
            if(bottoms[i] == domino1&&tops[i]!=domino1){
                if(count1!=Integer.MAX_VALUE)
                count1++;
            }else if(bottoms[i]!=domino1&&tops[i]!=domino1){
                count1 = Integer.MAX_VALUE;
            }

            if(bottoms[i] == domino2&&tops[i]!=domino2){
                if(count2!=Integer.MAX_VALUE)
                count2++;
            }else if(bottoms[i]!=domino2&&tops[i]!=domino2){
                count2 = Integer.MAX_VALUE;
            }

            if(tops[i] == domino1&&bottoms[i]!=domino1){
                if(count3!=Integer.MAX_VALUE)
                count3++;
            }else if(bottoms[i]!=domino1&&tops[i]!=domino1){
                count3 = Integer.MAX_VALUE;
            }

            if(tops[i] == domino2&&bottoms[i]!=domino2){
                if(count4!=Integer.MAX_VALUE)
                count4++;
            }else if(bottoms[i]!=domino2&&tops[i]!=domino2){
                count4 = Integer.MAX_VALUE;
            }
        }

        int ans = Math.min(count1,Math.min(count2,Math.min(count3,count4)));
        return (ans == Integer.MAX_VALUE)?-1:ans;
    }
}