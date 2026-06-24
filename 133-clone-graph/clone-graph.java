/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node clone(Node node,HashMap<Integer,Node> map){
        if(node==null)return null;
        if(map.containsKey(node.val))return map.get(node.val);
        ArrayList<Node> list = new ArrayList();
        Node newNode = new Node(node.val,list);
        map.put(node.val,newNode);
        for(Node ele : node.neighbors){
            if(map.containsKey(ele.val)){
                list.add(map.get(ele.val));
            }
            else{
                Node neighbour = clone(ele,map);
                list.add(neighbour);
            }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        
        HashMap<Integer,Node> map = new HashMap();
        return clone(node,map);
    }
}