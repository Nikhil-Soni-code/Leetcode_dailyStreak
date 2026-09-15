class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int no = 0;
        Arrays.sort(people);
        int i=0, j=people.length-1;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
            }
            no++;
            j--;

        }
        if(i==j)no++;
        return no;
    }
}