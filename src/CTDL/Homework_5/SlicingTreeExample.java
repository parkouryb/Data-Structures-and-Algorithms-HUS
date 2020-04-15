package CTDL.Homework_5;

public class SlicingTreeExample {
    public static void main(String[] args) {
        SlicingTree slicingTree = new SlicingTree();

        // build slicing Tree
        LinkedBinaryTree.Node<Rectangle> root = slicingTree.addRoot(
            new Rectangle("H", new Point(0, 0), new Point(0, 0))
        );

        // build tree by hand :D
        slicingTree.addLeft(root,
            new Rectangle("2", new Point(11, 11), new Point(12, 12))
        );
        slicingTree.addRight(root,
            new Rectangle("1", new Point(0, 0), new Point(10, 10))
        );

        // build tree by Cut function
//        slicingTree.horizontalCut(root, 9);
//        LinkedBinaryTree.Node<Rectangle> root_left = root.getLeft();
//        LinkedBinaryTree.Node<Rectangle> root_right = root.getRight();
//        slicingTree.verticalCut(root_left, 4);

        // Draw the slicing tree associated with the floor plan.
        slicingTree.printTree(root);
        slicingTree.assignTree(root);
        slicingTree.printTree(root);
    }
}
