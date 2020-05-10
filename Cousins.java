public class Cousins {
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
    boolean isSiblings(Node root,Node a,Node b){
        if(root==null){
            return false;
        }
        return (root.left==a && root.right==b) || (root.left==b && root.right==a) || isSiblings(root.left,a,b) || isSiblings(root.right,a,b);
    }
    int level(Node root,Node p,int l){
        if(root==null){
            return 0;
        }
        if(root==p){
            return l;
        }
        int u=level(root.left,p,l+1);
        if(u!=0) {
            return u;
        }
        return level(root.right,p,l+1);
    }
    boolean isCousin(Node root,Node a,Node b){
        if(level(root,a,1)==level(root,b,1) && !isSiblings(root,a,b)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Cousins tree = new Cousins();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(15);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        Node Node1, Node2;
        Node1 = tree.root.left.left;
        Node2 = tree.root.right.right;
        if (tree.isCousin(tree.root, Node1, Node2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}