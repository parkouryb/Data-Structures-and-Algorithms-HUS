package CTDL.Homework_5;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<E> {
    private E [] array;
    private int n = 0;
    private int defaultsize = 100;
    public ArrayBinaryTree(){
        array = (E[]) new Object[defaultsize];
    }

    public ArrayBinaryTree(int size){
        array = (E[]) new Object[size];

    }

    public void printArray() {
        System.out.println("n= " + this.n);
        for (int i = 0;i < array.length;++ i) {
            System.out.println(i + ": " + array[i]);
        }
    }

    //update methods
    public void setRoot(E element) {
        if (array[0] == null) {
            ++ n;
        }
        array[0] = element;
    }

    public void setLeft(int p, E element) throws Exception {
        try {
            if (array[p] == null)  {
                System.out.println("Warning: No parent!");
                return;
            }
            else {
                if (array[p * 2 + 1] == null)  {
                    ++ n;
                }

                array[p * 2 + 1] = element;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRight(int p, E element) {
        try {
            if (array[p] == null)  {
                System.out.println("Warning: No parent!");
                return;
            }
            else {
                if (array[p * 2 + 2] == null)  {
                    ++ n;
                }
                array[p * 2 + 2] = element;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public E root() {
        return array[0];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (n == 0);
    }

    @Override
    public int numChildren(Object p) {
        E parent = (E) p;
        int sum = 0;
        if (left(parent) != null) ++ sum;
        if (right(parent) != null) ++ sum;
        return sum;
    }

    @Override
    public Object parent(Object p) {
        Integer index = (Integer) p;
        if (index%2==0) return array[index / 2 - 1];
        return array[index / 2];
    }

    @Override
    public Object left(Object p) {
        Integer index = (Integer) p;
        index = index * 2 + 1;
        if (index < 0 || index > array.length) {
            System.out.println("Index out of bounds!");
            return null;
        }
        return array[index];
    }

    @Override
    public Object right(Object p) {
        Integer index = (Integer) p;
        index = index * 2 + 2;
        if (index < 0 || index > array.length) {
            System.out.println("Index out of bounds!");
            return null;
        }
        return array[index];
    }

    @Override
    public Object sibling(Object p) {
        Integer index = (Integer) p;
        if (index == 0) {
            System.out.println("No sibling for root.");
            return null;
        }
        if (index % 2 == 0) index -= 1;
        else index += 1;
        if (index > array.length || index < 0) {
            System.out.println("Index out of bounds!");
            return null;
        }
        return array[index];
    }

}