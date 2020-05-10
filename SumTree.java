public class SumTree {
    Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private int sum(Node root) {
        if(root==null) {
            return 0;
        }
        return sum(root.left) + root.data + sum(root.right);
    }

    private int isSum(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 1;
        } else {

            int ls = sum(root.left);
            int rs = sum(root.right);
            if((root.data==ls+rs) && (isSum(root.left)!=0) && (isSum(root.right)!=0)){
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        SumTree tree = new SumTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);
        if (tree.isSum(tree.root) != 0)
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }
}