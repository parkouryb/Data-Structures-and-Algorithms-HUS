package CTDL.Homework_5;

import java.security.spec.ECField;

public class BinaryTreeExample {


    public static void arrayBinaryTreeExample() throws Exception {
        ArrayBinaryTree<Integer> abt = new ArrayBinaryTree<Integer>((int) Math.pow(2, 5));

        System.out.println(abt.isEmpty());
        abt.setRoot(1);
        abt.setLeft(0, 3);
        abt.setLeft(1, 4);
        abt.setLeft(3, 2);
        abt.setRight(0, 1);
        abt.setRight(2, 5);
        abt.setRight(27, 5);

//        abt.printArray();
        abt.setLeft(3, 5);
        abt.printArray();
        System.out.println(abt.parent(1) + " " + abt.parent(2));
        System.out.println(abt.left(0) + " " + abt.right(2) + " " + abt.root() + " " + abt.sibling(0) + " " + abt.sibling(1) + " " + abt.sibling(2));
    }

    public static void linkedBinaryTreeExample() throws Exception {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();

        System.out.println(tree.isEmpty() + " " + tree.size());
        tree.addRoot(5);
        LinkedBinaryTree.Node<Integer> root = tree.root();
        tree.addRight(root, 2);
        tree.addLeft(root, 9);
        LinkedBinaryTree.Node<Integer> rl = root.getLeft();
        LinkedBinaryTree.Node<Integer> rr = root.getRight();

        System.out.println(root.getElement() + " " + rl.getElement() + " " + rr.getElement());

        tree.addRight(rl, 11);
        System.out.println(tree.isEmpty() + " " + tree.size());
        tree.addLeft(rl, 19);
        LinkedBinaryTree.Node<Integer> rlr = rl.getRight();
        System.out.println(tree.isEmpty() + " " + tree.size());
        LinkedBinaryTree.Node<Integer> rll = rl.getLeft();
        tree.set(rl, 110);

        System.out.println(tree.isEmpty() + " " + tree.size());
        System.out.println(root.getElement() + " " + rl.getElement() + " " + rr.getElement() + " " + rlr.getElement() + " " + rll.getElement());

        LinkedBinaryTree.Node<Integer> parent_rl = (LinkedBinaryTree.Node<Integer>) tree.parent(rl);
        LinkedBinaryTree.Node<Integer> sibling_rl = (LinkedBinaryTree.Node<Integer>) tree.sibling(rl);
        LinkedBinaryTree.Node<Integer> sibling_rr = (LinkedBinaryTree.Node<Integer>) tree.sibling(rr);

        System.out.println(parent_rl.getElement() + " " + sibling_rl.getElement() + " " + sibling_rr.getElement());
        System.out.println(tree.numChildren(root) + " " + tree.numChildren(rr) + " "  + tree.numChildren(rl) + " " + tree.numChildren(rlr));

        System.out.println("\n\n\n");
        tree.printTree(root);

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Homework 5");
//        arrayBinaryTreeExample();
        linkedBinaryTreeExample();

    }


}
