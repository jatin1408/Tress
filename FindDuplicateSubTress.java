class Solution {
     List<TreeNode> res;
    HashMap<String,Integer> hashing;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res=new ArrayList<>();
        hashing=new HashMap<>();
       getAll(root);
       return res; 
    }
    public String getAll(TreeNode root){
        if(root==null) return "#";
        String serial=root.val+","+ getAll(root.left)+","+getAll(root.right);
        int count=hashing.getOrDefault(serial,0)+1;
        hashing.put(serial,count);
        if(hashing.get(serial)==2){
            res.add(root);
        }
        return serial;
    }
}
