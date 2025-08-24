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
        StringBuilder sbr = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();
                if(node==null){
                    sbr.append("/,");
                }else{
                    sbr.append(node.val+",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        System.out.print(sbr.toString());
        return sbr.toString().substring(0,sbr.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String dat) {
        String[] data = dat.split(",");
        if(data[0].equals("/")){
            return null;
        }
        int idx = 0;

        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(data[idx++]));
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();
                if(idx<data.length){
                    if(!data[idx].equals("/")){
                        TreeNode newNode = new TreeNode(Integer.parseInt(data[idx++]));
                        node.left = newNode;
                        queue.add(newNode);
                    }else{
                        node.left = null;
                        idx++;

                    }
                }
                if(idx<data.length){
                                        if(!data[idx].equals("/")){

                        TreeNode newNode = new TreeNode(Integer.parseInt(data[idx++]));
                        node.right = newNode;
                        queue.add(newNode);

                    }else{
                        node.right = null;
                        idx++;
                    }
                }
            }
        }return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));