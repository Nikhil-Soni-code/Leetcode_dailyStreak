class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int no = 0;
        Arrays.sort(people);
        int i=0, j=people.length-1;
        while(i<=j){
            if(people[i]+people[j]>limit){
                no++;
                j--;
            }else if(people[i]+people[j]<=limit){
                no++;
                i++;
                j--;
            }

        }
        if(i==j)no++;
        return no;
    }
}