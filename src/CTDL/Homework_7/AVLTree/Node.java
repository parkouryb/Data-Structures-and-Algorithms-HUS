/* NomNom created on 5/20/2020 inside the package - CTDL.Homework_7 */

package CTDL.Homework_7.AVLTree;

public class Node<T extends Comparable> {
    public T data = null;
    public int height;
    public int rank = 0;
    public Node left, right, parent;

    public Node(Node parent) {
        left = null;
        right = null;
        this.parent = parent;
    }

    public Node(Node parent, T data) {
        this.data = data;
        this.height = 1;
        this.rank = 1;
        left = right = null;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "" + data +
                "" + rank +
                '}';
    }
}
