/* NomNom created on 5/26/2020 inside the package - CTDL.Homework_7.AVLTree */

package CTDL.Homework_7.AVLTree;

public class AVLTreeExample {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        /* Constructing tree given in the above figure */
        tree.addNode( 10);
        tree.printTree();
        System.out.println("---------------------");
        tree.addNode( 20);
        tree.printTree();
        System.out.println("---------------------");
        tree.addNode( 30);
        tree.printTree();
        System.out.println("---------------------");
        tree.addNode( 40);
        tree.printTree();
        System.out.println("---------------------");
        tree.addNode( 50);
        tree.printTree();
        System.out.println("---------------------");
        tree.addNode( 25);
        tree.printTree();
        System.out.println("---------------------");

        tree.delNode( 40);
        tree.printTree();
        System.out.println("---------------------");

        tree.delNode( 20);
        tree.printTree();
        System.out.println("---------------------");


        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */

    }
}
