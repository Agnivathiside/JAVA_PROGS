public class heap_implementation_shit {

    static void heapify(int arr[], int n, int i){
        int smallest=i;
        int left  = 2*i;
        int right = 2*i + 1;

        if (left < n && arr[smallest]>arr[left]){
            smallest=left;
        }
        if (right < n && arr[smallest]>arr[right]){
            smallest=right;
        }

        if (smallest!=i){
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;

            heapify(arr, n, smallest);
        }
    }
    public static void main(String[] args){
        heap h= new heap();
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);

        h.delete();
        h.print();
    }
}

class heap{
    int[] arr = new int[100];
    int size;

    heap(){
        arr[0]=-1;
        size=0;
    }

    void insert(int val){
        size+=1;
        int index=size;

        arr[index]=val;
        while (index>1){
            int parent = index/2;

            if (arr[parent]>arr[index]){
                // swap(arr[parent], arr[index]);
                int temp=arr[parent];
                arr[parent]=arr[index];
                arr[index]=temp;
                index=parent;
            }else{
                return;
            }
        }
    }

    void delete(){
        if (size==0){
            return;
        }

        arr[1]=arr[size];
        size--;

        int i=1;
        while (i<size){
            int leftIndex= 2*i;
            int rightIndex=2*i+1;

            if (leftIndex<size && arr[i]<arr[leftIndex]){
                int temp=arr[i];
                arr[i]=arr[leftIndex];
                arr[leftIndex]=temp;

                i=leftIndex;
            }
            else if (rightIndex<size && arr[i]<arr[rightIndex]){
                int temp=arr[i];
                arr[i]=arr[rightIndex];
                arr[rightIndex]=temp;

                i=rightIndex;
            }else {
                return;
            }
        }
    }

    void print(){
        for (int i=1;i<=size;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
