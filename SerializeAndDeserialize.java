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
            return null;
        }
        StringBuilder s=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode p=q.poll();
            if(p==null){
                s.append("n ");
            }
            else{
                s.append(p.val+" ");
                q.add(p.left);
                q.add(p.right);
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null){
            return null;
        }
        Queue<TreeNode> q=new LinkedList<>();
        String[] d=data.split(" ");
        TreeNode res=new TreeNode(Integer.parseInt(d[0]));
        q.add(res);
        for(int i=1;i<d.length;i++){
            TreeNode parent=q.poll();
            if(!d[i].equals("n")){
            TreeNode left=new TreeNode(Integer.parseInt(d[i]));
            parent.left=left;
            q.add(left);
        }
             if(!d[++i].equals("n")){
           TreeNode right=new TreeNode(Integer.parseInt(d[i]));
            parent.right=right;
            q.add(right);
        }
    }
        return res;
}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
