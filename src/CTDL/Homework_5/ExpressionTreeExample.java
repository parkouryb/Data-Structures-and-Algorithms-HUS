package CTDL.Homework_5;


public class ExpressionTreeExample {
    public static void Exc2() {
        ExpressionTree<String> tree = new ExpressionTree<String>();

        tree.addRoot("*");
        LinkedBinaryTree.Node<String> root = tree.root();
        LinkedBinaryTree.Node<String> root_l = tree.addLeft(root, "+");
        LinkedBinaryTree.Node<String> root_r = tree.addRight(root, "-");
        LinkedBinaryTree.Node<String> root_l_l = tree.addLeft(root_l, "/");
        LinkedBinaryTree.Node<String> root_l_r = tree.addRight(root_l, "3");
        LinkedBinaryTree.Node<String> root_l_l_l = tree.addLeft(root_l_l, "61.121");
        LinkedBinaryTree.Node<String> root_l_l_r = tree.addRight(root_l_l, "2");
        LinkedBinaryTree.Node<String> root_r_l = tree.addLeft(root_r, "7");
        LinkedBinaryTree.Node<String> root_r_r = tree.addRight(root_r, "10");

        tree.inorderPrint(root);
        tree.preoderPrint(root);
        tree.postorderPrint(root);

        System.out.println("Sum= " + tree.Evalution_Of_Tree(root));
    }

    public static void Exc3() {
        ExpressionTree<String> tree = new ExpressionTree<String>();

        String s = "-(-(-1 + 2)) * 4 + 5.15";
        String exp = tree.pre_infix(s);
        System.out.println(exp);
        System.out.println(tree.infix_postfix(exp));

        LinkedBinaryTree.Node<String> root = tree.constructTree(tree.infix_postfix(exp));

        tree.inorderPrint(root);
        tree.preoderPrint(root);
        tree.postorderPrint(root);
//        tree.printTree(root);

        System.out.println(tree.Evalution_Of_Tree(root));
    }

    public static void main(String[] args) {
        Exc3();
    }
}