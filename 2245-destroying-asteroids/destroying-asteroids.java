class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for(int stone : asteroids){
            if(m >= stone){
                m+=stone;
            }else{
                return false;
            }
        }
        return true;
    }
}