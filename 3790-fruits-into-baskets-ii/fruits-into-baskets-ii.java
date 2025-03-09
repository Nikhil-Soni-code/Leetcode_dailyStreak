class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<fruits.length;j++){
                if(fruits[i]<=baskets[j]){
                    n--;
                    baskets[j] = 0;
                    break;
                }
            }
        }
        return n;
    }
}