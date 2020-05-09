public class MaxHeap{
    private int[] heap;
    private int max_size;
    private int size;

    public MaxHeap(int max_size) {
        this.max_size = max_size;
        this.size=0;
        heap = new int[this.max_size + 1];
        heap[0] = Integer.MAX_VALUE;
    }
    private int parent(int i){
        return i/2;
    }
    private void swap(int s,int d){
        int temp=heap[s];
        heap[s]=heap[d];
        heap[d]=temp;
    }
    private int get_left(int i){
        return 2*i;
    }
    private int get_right(int i){
        return (2*i)+1;
    }
    private void insert(int key){
        heap[++size]=key;
        int current=size;
        while (heap[current]>heap[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }

    }
   private boolean is_Leaf(int pos){
       if (pos >= (size / 2) && pos <= size) {
           return true;
       }
       return false;
   }
    private void maxHeapify(int pos){
        if(is_Leaf(pos)){
            return;
        }
        if(heap[pos]<heap[get_left(pos)] || heap[pos]<heap[get_right(pos)]){
            if(heap[pos]<heap[get_left(pos)]){
                swap(pos,get_left(pos));
                maxHeapify(get_left(pos));
            }
            else {
                swap(pos,get_right(pos));
                maxHeapify(get_right(pos));
            }
        }
    }
    private void print(){
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
                    heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }
    private int extract_max(){
        int temp=heap[1];
        heap[1]=heap[size--];
        maxHeapify(1);
        return temp;

    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
        System.out.println(maxHeap.extract_max());
        maxHeap.print();
      
    }
}