/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder serialize = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        serialize.append(root.val);
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                    serialize.append(',');
                    serialize.append(node.left.val);
                }else{
                    serialize.append(",#");
                }
                if(node.right!=null){
                    queue.add(node.right);
                    serialize.append(',');
                    serialize.append(node.right.val);
                }else{
                    serialize.append(",#");
                }
            }
        }
        System.out.println(serialize.toString());
        return serialize.toString();
        

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        if(d[0]==""){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(d[0]));
        int idx = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(idx<d.length){
                if(!d[idx].equals("#")){
                    TreeNode newNode = new TreeNode(Integer.parseInt(d[idx++]));
                    node.left=newNode;
                    queue.add(newNode);
                }else{
                    node.left=null;
                    idx++;
                }
            }
            if(idx<d.length){
                if(!d[idx].equals("#")){
                    TreeNode newNode = new TreeNode(Integer.parseInt(d[idx++]));
                    node.right=newNode;
                    queue.add(newNode);
                }else{
                    node.right=null;
                    idx++;
                }
            }
        }
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));