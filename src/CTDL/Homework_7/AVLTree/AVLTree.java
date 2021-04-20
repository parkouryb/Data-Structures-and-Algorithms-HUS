/* NomNom created on 5/26/2020 inside the package - CTDL.Homework_7.AVLTree */

package CTDL.Homework_7.AVLTree;
// T1, T2 and T3 are subtrees of the tree
// rooted with y (on the left side) or x
// (on the right side)
//       y                               x
//      / \     Right Rotation          /  \
//     x   T3   - - - - - - - >        T1   y
//    / \       < - - - - - - -            / \
//  T1  T2      Left Rotation             T2  T3
// Keys in both of the above trees follow the
// following order
// keys(T1) < key(x) < keys(T2) < key(y) < keys(T3)
// So BST property is not violated anywhere.

public class AVLTree<T extends Comparable> {
    // <T extends Comparable> kieu generic
    // cái này nghĩa là T kế thừa thằng comparable
    // thằng comparable là 1 cái interface
    // có phương thức compareTo so sánh với
    // trả về các giá trị -1, 0, 1 nếu
    // -1 là thằng gốc nhỏ hơn thằng được so sánh
    // 0 là thằng gốc = thằng so sánh
    // 1 là thằng gốc lớn hơn thằng được so sánh
    // compareTo là phương thức so sánh giữa 2 đối tượng

    public Node root; // nut goc
    public int n = 0; // dai dien cho so phan tu trong cay

    protected int height(Node node) { // ham height truyen vao 1 node de lay chieu cao cua node day
        if (node == null)
            return 0;
        return node.height;
    }

    // This function uses to right rotate subtree rooted with y
    private Node rightRotate(Node y, Node parentY) {
        Node x = (y.left == null) ? new Node(y) : y.left;
        Node T2 = x.right;

        x.right = y;
        x.parent = parentY;
        y.parent = x;

        y.left = T2;
        if (T2 != null) // neu t2 khac null thi t2.parent = y
            T2.parent = y;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // This function uses to left rotate subtree rooted with x
    private Node leftRotate(Node x, Node parentX) {
        Node y = (x.right == null) ? new Node(x) : x.right;
        Node T2 = y.left;

        y.left = x;
        y.parent = parentX;
        x.parent = y;
        x.right = T2;

        if (T2 != null)
            T2.parent = x;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private int getBalance(Node node) { //
        if (node == null)
            return 0;
        return (height(node.left) - height(node.right));
    }

    private Node insert(Node node, Node parent, T data) {
        if (node == null) {
            return (new Node(parent, data));
        }
        int keyCompare = data.compareTo(node.data);
        if (keyCompare < 0) {
            node.left = insert(node.left, node, data);
        }
        else if (keyCompare > 0) {
            node.right = insert(node.right, node, data);
        }
        else // Duplicate data is not allowed
            return node;

        // cập nhật chiều cao của node, cây con
        node.height = 1 + Math.max(height(node.left)
                                 , height(node.right));

        int balance = getBalance(node);

        /* If this node becomes unbalanced then there are 4 cases */
        if (balance > 1 && data.compareTo(node.left.data) < 0) { // Left Left case
//            System.out.println("LLC");
            return rightRotate(node, parent);
        }
        if (balance < -1 && data.compareTo(node.right.data) > 0) { //Right Right case
//            System.out.println("RRC");
            return leftRotate(node, parent);
        }
        if (balance > 1 && data.compareTo(node.left.data) > 0) { // Left Right case
//            System.out.println("LRC");
            node.left = leftRotate(node.left, node);
            return rightRotate(node, parent);
        }
        if (balance < -1 && data.compareTo(node.right.data) < 0) { // Right Left case
//            System.out.println("RLC");
            node.right = rightRotate(node.right, node);
            return leftRotate(node, parent);
        }

        return node;
    }

    private Node minValueNode(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    private Node delete(Node node, Node parent, T data) {
        if (node == null)
            return node;

        int keyCompare = data.compareTo(node.data);
        if (keyCompare < 0)
            node.left = delete(node.left, node, data);
        else if (keyCompare > 0)
            node.right = delete(node.right, node, data);
        else {
            // tim duoc node cần xóa
            if (node.left == null || node.right == null) {
                // trường hợp node cần xóa có
                // 1 cây con ở bên trái hoặc bên phải
                Node temp = null;
                temp = (node.left == null) ? node.right : node.left;

                node = temp;
            } else {
                // trường hợp mà node cần xóa có cả 2 con trái và phải
                Node temp = minValueNode(node.right);
                node.data = temp.data;
                node.right = delete(node.right, node, (T) temp.data);
            }
        }

        if (node == null)
            return node;

        node.height = 1 + Math.max(height(node.left)
                , height(node.right));

        int balance = getBalance(node);

        /* If this node becomes unbalanced, then there are 4 cases */
        if (balance > 1 && getBalance(node.left) >= 0) { // Left Left case
            return rightRotate(node, parent);
        }
        if (balance > 1 && getBalance(node.left) < 0) { // Left Right case
            node.left = leftRotate(node.left, node);
            return rightRotate(node, parent);
        }

        if (balance < -1 && getBalance(node.right) <= 0) { // Right Right case
            return leftRotate(node, parent);
        }
        if (balance < -1 && getBalance(node.right) > 0) { // Right Left case
            node.right = rightRotate(node.right, node);
            return leftRotate(node, parent);
        }

        return node;
    }

    public void addNode(T data) {
        if (n == 500) {
            System.out.println("bai gui xe het cho");
            return;
        }
        // thủ tục thêm 1 node mới vào với giá trị là data
        if (this.root == null) {
            // cái if này
            this.root = new Node(null, data);
            this.root.parent = null;
            n += 1;
            return;
        }
        this.root = insert(this.root, null, data);
        n += 1;
    }

    public void delNode(T data) {
        this.root = delete(this.root, this.root.parent, data);
        n -= 1;
    }

    private final int COUNT = 10;

    private void print2DUtil(Node root, int space) {
        if (root == null)
            return;
        space += COUNT;
        print2DUtil(root.right, space);
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root + "\n");
        print2DUtil(root.left, space);
    }

    public void printTree() {
        print2DUtil(this.root, 0);
    }

    public T search(Node temp, T x) {
        // ham nay tra ve node trong cay neu tim duoc
        // con neu k tim duoc tra ve null
        try {
            // try catch để bắt ngoại lệ
            if (x.compareTo(temp.data) == 0) {
                // tim thay node co cung gia tri, tuc la tim thay ket qua
                System.out.println("Item found!");
                return (T) temp.data;
            }
            else {
                if (x.compareTo(temp.data) < 0) {
                    // neu gia tri can tim nho hon thang node dang xet
                    // thi minh can den node ben trai
                    temp = temp.left;
                    return search(temp, x);//recursive call
                } else {
                    // tuong tu thang left nma day la lon hon
                    temp = temp.right;
                    return search(temp, x);//recursive call
                }
            }
        } catch (NullPointerException e) {
            System.out.println ("Search failed!");
            return null;
        }
    }
}
