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
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder serialized = new StringBuilder();
        if(root==null)return serialized.toString();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node==null)serialized.append("#,");
                else {serialized.append(node.val+",");
                queue.add(node.left);

                queue.add(node.right);}
            }
        }
        System.out.println(serialized.toString().substring(0,serialized.length()-1));
        return serialized.toString().substring(0,serialized.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0||data.charAt(0)=='#')return null;
        String [] tree = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int idx = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(tree[idx].equals("#"))node.left = null;
                else{
                    node.left = new TreeNode(Integer.parseInt(tree[idx]));
                    queue.add(node.left);
                    
                    }
                idx++;
                if(tree[idx].equals("#"))node.right = null;
                else {
                    node.right = new TreeNode(Integer.parseInt(tree[idx]));
                    queue.add(node.right);
                }
                idx++;
            }
        }   



        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));