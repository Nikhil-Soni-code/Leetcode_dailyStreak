class Solution {
    private int[] findScore(String word){
        int[] diff = new int[word.length()-1];
        for(int i=1;i<word.length();i++){
            diff[i-1] = word.charAt(i)-word.charAt(i-1);
        }
        return diff;
    }
    public String oddString(String[] words) {
        String[] diff = new String[words.length];
        for(int i=0;i<words.length;i++){
            String word = words[i];
            int[] score = findScore(word);
            String s = "";
            for(int j=0;j<score.length;j++){
                s+=score[j]+",";
            }
            diff[i] = s;
        }
        HashMap<String,Integer> map = new HashMap();
        for(int i=0;i<diff.length;i++){
            map.put(diff[i],map.getOrDefault(diff[i],0)+1);
        }
        String differ = "";

        for(String s:map.keySet()){
            if(map.get(s)==1){
                differ = s;
                break;
            }
        }
        for(int i=0;i<diff.length;i++){
            if(diff[i].equals(differ)){
                return words[i];
            }
        }return "";
        


    }
}