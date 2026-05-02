class Solution {
    public int rotatedDigits(int n) {
        HashSet<Integer> set = new HashSet();
        set.add(0);
        set.add(1);
        set.add(8);
        set.add(3);
        set.add(4);
        set.add(7);



        int count = 0;
        for(int i=1 ; i<=n ; i++){
            int num = i;
            int unrotated = 0;
            boolean invalid = false;
            int size = 0;
            while(num!=0){
                int dig = num%10;
                if(dig==3 || dig==4 || dig==7){
                        invalid = true;
                        break;
                }
                if(set.contains(dig)){
                    unrotated++;
                }
                size++;
                num = num/10;
            }
            
            if(!invalid && size!=unrotated){
                System.out.println(i);
                count++;
            }
        }return count;

    }
}