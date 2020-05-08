/* NomNom created on 4/27/2020 inside the package - CTDL.Homework_6 */

package CTDL.Homework_6;

public class MinHeapPriorityQueue<K extends Comparable, E extends Comparable>
        extends SortedArrayPriorityQueue {
    ArrEntry <K, E> [] heapPQ;
    private int n = 0;
    private int defaultsize = 1000000;

    public MinHeapPriorityQueue() {
        heapPQ = new ArrEntry[defaultsize];
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public boolean isEmpty() {
        return this.n == 0;
    }

    @Override
    public void insert(Entry entry) {
        if (this.n == defaultsize)
            return;
        heapPQ[this.n] = new ArrEntry(entry.getKey(), entry.getValue());
        upHeap();
        this.n += 1;
    }

    @Override
    public void insert(Object o, Object o2) {
        if (this.n == defaultsize)
            return;
        heapPQ[this.n] = new ArrEntry(o, o2);
        upHeap();
//        printTree(0);
//        System.out.println("--------------------------------------------");
        this.n += 1;
    }

    public Entry removeTop() {
        if (isEmpty()) return null;
        Entry result = heapPQ[0];
        heapPQ[0] = heapPQ[this.n - 1];
        heapPQ[this.n - 1] = null;
        -- this.n;
        downHeap();
        return result;
    }

    public Entry top() {
        if (isEmpty()) return null;
        return heapPQ[0];
    }

    protected void upHeap(){
        int index = this.n;
        while (true) {
            if (index == 0) break;
            int parentIndex = (index / 2);
            if (index % 2 == 0) parentIndex -= 1;
            int bool = heapPQ[parentIndex].getKey().compareTo(heapPQ[index].getKey());
            if (bool != 0) {
                if (bool > 0) {
                    ArrEntry<K, E> temp = heapPQ[parentIndex];
                    heapPQ[parentIndex] = heapPQ[index];
                    heapPQ[index] = temp;
                    index = parentIndex;
                }
                else
                    break;
            }
            else {
                int bool2 = heapPQ[parentIndex].getValue().compareTo(heapPQ[index].getValue());
                if (bool2 > 0) {
                    ArrEntry<K, E> temp = heapPQ[parentIndex];
                    heapPQ[parentIndex] = heapPQ[index];
                    heapPQ[index] = temp;
                    index = parentIndex;
                }
                else
                    break;
            }
        }
    }

    protected void downHeap() {
        int index = 0;
        while (true) {
            int childIndex = index * 2 + 1;
            int childIndex2 = index * 2 + 2;
            if (childIndex2 < size()) {
                int value = heapPQ[childIndex].getKey().compareTo(heapPQ[childIndex2].getKey());
                if (value != 0) {
                    if (value > 0) {
                        int temp = childIndex;
                        childIndex = childIndex2;
                        childIndex2 = temp;
                    }
                }
                else {
                    value = heapPQ[childIndex].getValue().compareTo(heapPQ[childIndex2].getValue());
                    if (value > 0) {
                        int temp = childIndex;
                        childIndex = childIndex2;
                        childIndex2 = temp;
                    }
                }
            }
            if (childIndex >= size()) break;
            boolean flag = true;
            int bool = heapPQ[index].getKey().compareTo(heapPQ[childIndex].getKey());
            if (bool != 0) {
                if (bool > 0) {
                    ArrEntry temp = heapPQ[index];
                    heapPQ[index] = heapPQ[childIndex];
                    heapPQ[childIndex] = temp;
                    index = childIndex;
                }
                else {
                    if (childIndex2 < size()) {
                        bool = heapPQ[index].getKey().compareTo(heapPQ[childIndex2].getKey());
                        if (bool != 0) {
                            if (bool > 0) {
                                ArrEntry temp = heapPQ[index];
                                heapPQ[index] = heapPQ[childIndex2];
                                heapPQ[childIndex2] = temp;
                                index = childIndex2;
                            }
                            else break;
                        }
                        else {
                            bool = heapPQ[index].getValue().compareTo(heapPQ[childIndex2].getValue());
                            if (bool > 0) {
                                ArrEntry temp = heapPQ[index];
                                heapPQ[index] = heapPQ[childIndex2];
                                heapPQ[childIndex2] = temp;
                                index = childIndex2;
                            }
                            else break;
                        }
                    }
                    else break;
                }
            }
            else {
                bool = heapPQ[index].getValue().compareTo(heapPQ[childIndex].getValue());
                if (bool > 0) {
                    ArrEntry temp = heapPQ[index];
                    heapPQ[index] = heapPQ[childIndex];
                    heapPQ[childIndex] = temp;
                    index = childIndex;
                }
                else break;
            }

        }
    }

    static final int COUNT = 10;

    private void print2DUtil(int root, int space) {
        if (root < 0 || root > this.n || heapPQ[root] == null)
            return;

        space += COUNT;
        print2DUtil(root * 2 + 2, space);

        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(heapPQ[root] + "\n");

        print2DUtil(root * 2 + 1, space);
    }

    public void printTree(int root) {
        print2DUtil(root, 0);
    }
}
