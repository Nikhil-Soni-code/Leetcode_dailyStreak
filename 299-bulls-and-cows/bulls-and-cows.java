class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> map = new HashMap();
        int bulls = 0,cows = 0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }else{
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
            }
        }
        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i)!=guess.charAt(i)&&map.containsKey(guess.charAt(i))){
                cows++;
                map.put(guess.charAt(i),map.get(guess.charAt(i))-1);
                if(map.get(guess.charAt(i))==0)map.remove(guess.charAt(i));
            }
        }
        return bulls+"A"+cows+"B";
    }
}