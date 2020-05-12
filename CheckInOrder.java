import java.util.ArrayList;

public class CheckInOrder{
    Node root;
    static  int preIndex=0;
    ArrayList<Character> arrayList=new ArrayList<>();
    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
     Node build_tree(char[] in,char[] pre,int start,int end){
        if(start>end){
            return null;
        }
        char data=pre[preIndex++];
        Node n=new Node(data);
        if(start==end){
            return n;
        }
        int ind=search(in,start,end,data);
        n.left=build_tree(in,pre,start,ind-1);
        n.right=build_tree(in,pre,ind+1,end);
        return n;
    }
    int search(char[] s,int start,int end,char d){
        int i;
        for( i=start;i<=end;i++){
            if(s[i]==d){
                return i;
            }

        }
        return i;
    }
    void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        arrayList.add(root.data);
        inOrder(root.right);
    }
    public static void main(String[] args) {
        CheckInOrder c=new CheckInOrder();
        char[] in={ 'D','B','E','A','F','C'};
        char[] pre={'A','B','D','E','C','F'};
        int n=in.length-1;
        int s=0;
        boolean flag=true;
        c.root=c.build_tree(in,pre,s,n);
        c.inOrder(c.root);
        ArrayList<Character> arrayList=c.arrayList;
        c.arrayList.clear();
        for(int i=0;i<=n;i++){
            if(in[i]!=arrayList.get(i)){
                flag=false;
                System.out.println("NOT SIMILAR");
                break;
            }
        }
        if(flag){
            System.out.println("SIMILAR");
        }
    }
}