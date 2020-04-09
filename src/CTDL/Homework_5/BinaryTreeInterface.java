package CTDL.Homework_5;

public interface BinaryTreeInterface<E> {
    E root();
    int size();
    boolean isEmpty();
    int numChildren(E p);

    E parent(E p);
    E left(E p);
    E right(E p);
    E sibling(E p) throws Exception;
}
