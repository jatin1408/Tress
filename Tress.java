import java.util.Scanner;

public class Tress {
    Node root;
    static class Node{
        //definition of our node class
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            this.left=this.right=null;
        }
    }

    public Tress() {
        this.root=null;
    }

    void inorder(Node root){
        // in  inorder traversal we travel left,root and then right
        if(root!=null){
            // checking if the tree is not empty
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

    }
    void preorder(Node root){
        // in preorder traversal we travel root,left and then right
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

    }
    void postorder(Node root){
        // in postorder traversal we travel left,right and then root
        if(root!=null){
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    }
    Node insert(Node root,int data){
        if(root==null){
            //whenever we find any empty node then we add our new node there
            root=new Node(data);
            return root;
        }
        if(data<root.data){
            //if the value is smaller than root value we recurse down to left part of tree
            root.left=insert(root.left,data);
        }
        else if(data>root.data){
            //if the value is greater than root value we recurse down to right part of tree
            root.right=insert(root.right,data);
        }
        return root;
    }
    Node delete(Node root,int value){
        if(root==null){
            // if the tree is empty
            return root;
        }
        //searching the value
        if(value<root.data){
            root.left=delete(root.left,value);
        }
        else if(value>root.data){
            root.right=delete(root.right,value);
        }
        else{
         // this is the node that we have to delete
            if(root.left==null){
                // node is having only one child
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            // node having two child

            root.data=min(root);
            root.right=delete(root.right,root.data);

        }
        return root;
    }
    int min(Node root){
        int t=root.data;
        while (root.left!=null){
            t=root.left.data;
            root=root.left;
        }
        return t;
    }
    void remove(int data){
        this.root=delete(this.root,data);
    }
    void insert(int data){
        //method overloading
        this.root=insert(this.root,data);
    }
    void inorder(){
        inorder(this.root);
    }
    void preorder(){
        preorder(this.root);
    }
    void postorder(){
        postorder(this.root);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Tress t=new Tress();

        while (true){
            System.out.println("Enter 1 to insert value");
            System.out.println("Enter 2 to traverse in preorder");
            System.out.println("Enter 3 to traverse in postorder");
            System.out.println("Enter 4 to traverse in inorder");
            System.out.println("Enter 5 to delete a node");
            System.out.println("Enter 6 to quit");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter value to insert");
                    t.insert(sc.nextInt());
                    break;
                case 2:
                    t.preorder();
                    System.out.println();
                    break;
                case 3:
                    t.postorder();
                    System.out.println();
                    break;
                case 4:
                    t.inorder();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Enter the value that you want to delete");
                    t.remove(sc.nextInt());
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter a valid choice");


            }
        }
}
}