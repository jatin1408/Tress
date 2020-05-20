class Scratch {
    Node root;

    static class Node{
        Node left,right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
    Node cga(Node root,Node n1,Node n2){
        if(root==null)
            return null;
        if(root==n1 || root==n2)
            return root;
        Node left=cga(root.left,n1,n2);
        Node right=cga(root.right,n1,n2);
        if(left==null && right==null)
            return null;

        if(left!=null && right!=null)
            return root;
        return (left!=null?left:right);
    }
    int distance(Node root,Node x){
        if(root==null){
            return -1;
        }
        int dist=-1;
        if(root==x || (dist=distance(root.left,x))>=0 || (dist=distance(root.right,x))>=0){
            return dist+1;
        }
        return dist;
    }
    public static void main(String[] args) {
        Scratch s=new Scratch();
        Node  root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        Node ans=s.cga(root,root.right.left.right,root.left.right);
        int x=s.distance(ans,root.left.right);
        int y=s.distance(ans,root.right.left.right);
        System.out.println(x+y);


    }
}
