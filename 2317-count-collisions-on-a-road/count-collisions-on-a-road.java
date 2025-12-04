class Solution {
    public int countCollisions(String directions) {
        int left = 0;
        int right = directions.length()-1;
        int n = directions.length();
        int collisions = 0;
        while(left<n && directions.charAt(left)=='L')left++;
        while(right>=0 && directions.charAt(right)=='R')right--;
        for(int i = left;i <= right ; i++){
            if(directions.charAt(i)!='S')collisions++;
        } return collisions;

    }
}