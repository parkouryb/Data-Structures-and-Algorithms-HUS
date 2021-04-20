/* NomNom created on 5/20/2020 inside the package - CTDL.Homework_7 */

package CTDL.Homework_7.AVLTree;

public class Node<T extends Comparable> {
    public T data = null;
    public int height;
    public Node left, right, parent;

    // hàm khởi tạo
    public Node(Node parent) {
        left = null;
        right = null;
        this.parent = parent;
    }

    public Node(Node parent, T data) {
        // ham khoi tao nay truyen vao node cha, va gia tri data
        // luu tru tai node

        this.data = data;
        this.height = 1;
        left = right = null;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "" + data +
                '}';
    }
}
