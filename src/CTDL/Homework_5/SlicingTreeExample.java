package CTDL.Homework_5;

public class SlicingTreeExample {
    public static void main(String[] args) {
        SlicingTree slicingTree = new SlicingTree();

        // build slicing Tree
        LinkedBinaryTree.Node<Rectangle> root = slicingTree.addRoot(
            new Rectangle("1", new Point(0, 0), new Point(10, 10))
        );

        slicingTree.horizontalCut(root, 9);
        LinkedBinaryTree.Node<Rectangle> root_left = root.getLeft();
        LinkedBinaryTree.Node<Rectangle> root_right = root.getRight();
        slicingTree.verticalCut(root_left, 4);

        // Draw the slicing tree associated with the floor plan.
        slicingTree.printTree(root);
    }
}
