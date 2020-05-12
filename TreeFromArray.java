//link of the question-
//https://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
public class TreeFromArray {
    Node root;
    boolean[] visited;
    int n;
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public TreeFromArray(int n) {
        this.n = n;
        visited=new boolean[n];
        for(int i=0;i<n;i++) {
            visited[i]=false;
        }
    }

    Node tree(Node root, int[] arr, int key){
        if(root==null){
            return null;
        }
        int[] a=search(arr,key,visited);
        if(a[0]!=-1){
            root.left=new Node(a[0]);
        }
        if(a[1]!=-1){
            root.right=new Node(a[1]);
        }

         tree(root.left,arr,a[0]);
         tree(root.right,arr,a[1]);
         return root;
    }
    int[] search(int[] arr,int key,boolean[] visited){
        int[] a={-1,-1};
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key && visited[i]==false){
                a[0]=i;
                visited[i]=true;
                break;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key && visited[i]==false){
                a[1]=i;
                visited[i]=true;
                break;
            }
        }
        return a;
    }
    public void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int[] a={1, 5, 5, 2, 2, -1, 3};
        int n=a.length;
        TreeFromArray s=new TreeFromArray(n);
        for(int i=0;i<n;i++){
            if(a[i]==-1){
                s.root=new Node(i);
                s.visited[i]=true;
                s.tree(s.root,a,i);
                break;
            }
        }

        s.inOrder(s.root);
    }
}