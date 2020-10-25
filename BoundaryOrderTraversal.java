import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Scratch {
    Node root;
    static class Node{
        Node left;
        Node right;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    void boundaryOrderTraversal(){
        if(root==null)
            return;
        ArrayList<Integer> arrayList=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> temp=new ArrayList<>();
        while (!queue.isEmpty()){
            int size=queue.size();
            int array_size=temp.size();
            if(array_size==1){
                arrayList.add(temp.get(0));
            }
            if(array_size>1){
                arrayList.add(temp.get(0));
                arrayList.add(temp.get(array_size-1));
            }
            temp.clear();
            for(int i=0;i<size;i++){
                Node n=queue.poll();
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
                temp.add(n.val);
            }
        }
        for(Integer obj:temp){
            arrayList.add(obj);
        }
        for(Integer obj:arrayList){
            System.out.print(obj+" ");
        }

    }
    public static void main(String[] args) {
        Scratch tree = new Scratch();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.boundaryOrderTraversal();
    }
}
