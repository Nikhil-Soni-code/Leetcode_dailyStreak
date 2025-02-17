class Solution {
    private void possibility(StringBuilder tiles,StringBuilder seq,HashSet<String> set){
        for(int i=0;i<tiles.length();i++){
            char ch = tiles.charAt(i);
            seq.append(ch);
            set.add(seq.toString());
            tiles.deleteCharAt(i);
            possibility(tiles,seq,set);
            tiles.insert(i,ch);
            seq.deleteCharAt(seq.length()-1);
        }
    }
    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet();
        possibility(new StringBuilder(tiles),new StringBuilder(),set);
        return set.size();
    }
}