package CTDL.Homework_5;

public class LinkedBinaryTree<E> implements BinaryTreeInterface {

    protected static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            this.element = element;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    private Node<E> root = null;
    private int n = 0;

    public LinkedBinaryTree() {
    }

    public Node<E> addRoot(E element) {
        if (!isEmpty()) {
            System.out.println("Tree not empty.");
            return root;
        }
        ++ n;
        root = new Node<E>(element, null, null, null);
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        if (p.left != null) {
            System.out.println("p.left got element.");
            return p.getLeft();
        }
        ++ n;
        p.setLeft(new Node<E>(element, p, null, null));
        return p.getLeft();
    }

    public Node<E> addRight(Node<E> p, E element) {
        if (p.right != null) {
            System.out.println("p.right got element.");
            return p.getRight();
        }
        ++ n;
        p.setRight(new Node<E>(element, p, null, null));
        return p.getRight();
    }

    public void set(Node<E> p, E element) {
        Node<E> node = p;
        
        node.setElement(element);
    }

    @Override
    public Node<E> root() {
        return root;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (n==0);
    }

    @Override
    public int numChildren(Object p) {
        Node<E> node = (Node<E>) p;
        int count = 0;
        if (node.getLeft() != null) ++ count;
        if (node.getRight() != null) ++ count;
        return count;
    }

    @Override
    public Object parent(Object p) {
        Node<E> node = (Node<E>) p;
        return (Node<E>) node.getParent();
    }

    @Override
    public Object left(Object p) {
        Node<E> node = (Node<E>) p;
        return (Node<E>) node.getLeft();
    }

    @Override
    public Object right(Object p) {
        Node<E> node = (Node<E>) p;
        return (Node<E>) node.getRight();
    }

    @Override
    public Object sibling(Object p) throws Exception {
        Node<E> node = (Node<E>) p;
        if (node.getParent().getLeft() == node) {
            return (Node<E>) node.getParent().getRight();
        }
        else {
            return (Node<E>) node.getParent().getLeft();
        }
    }

    static final int COUNT = 10;

    private void print2DUtil(Node<E> root, int space) {
        if (root == null)
            return;

        space += COUNT;

        print2DUtil(root.right, space);

        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.getElement() + "\n");

        print2DUtil(root.left, space);
    }

    public void printTree(Node<E> root) {
        print2DUtil(root, 0);
    }
}
