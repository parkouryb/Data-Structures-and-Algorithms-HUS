/* NomNom created on 5/26/2020 inside the package - CTDL.Homework_7.OneDRangeSearch */

package CTDL.Homework_7.OneDRangeSearch;

import CTDL.Homework_7.AVLTree.AVLTree;
import CTDL.Homework_7.AVLTree.Node;

import java.util.LinkedList;
import java.util.Queue;

/** 1-D range search */
public class ODRS<T extends Comparable> extends AVLTree {
    private LinkedList<Node> result = new LinkedList<>();
    private Queue<Node> queue = new LinkedList<>();

    private boolean isValid(int low, int high) {
        return low >= 0 && high <= 0;
    }

    public void search(T low, T high) {
        queue.clear();
        result.clear();

        queue.add(super.root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.peek();
            queue.remove();
            if (currentNode == null) continue;
            int cKey_1 = currentNode.data.compareTo(low);
            int cKey_2 = currentNode.data.compareTo(high);
            if (isValid(cKey_1, cKey_2)) {
                result.add(currentNode);
            }
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }

        System.out.print("Range from " + low + " to " + high + " : ");
        for (Node data: result) {
            System.out.print(data.data + " ");
        }
        System.out.println();
    }

    public int count(T low, T high) {
        queue.clear();
        queue.add(super.root);

        Node lowRs = new Node(null), highRs = new Node(null);
        while(!queue.isEmpty()) {
            Node currentNode = queue.peek();
            queue.remove();
            if (currentNode == null) break;
            int keyCompare = low.compareTo(currentNode.data);
            if (keyCompare != 0) {
                if (keyCompare < 0) {
                    queue.add(currentNode.left);
                    lowRs = currentNode;
                }
                else {
                    queue.add(currentNode.right);
                }
            }
            else {
                lowRs = currentNode;
            }
        }
        queue.clear();

        queue.add(super.root);
        while(!queue.isEmpty()) {
            Node currentNode = queue.peek();
            queue.remove();
            if (currentNode == null) break;
            int keyCompare = high.compareTo(currentNode.data);
            if (keyCompare != 0) {
                if (keyCompare < 0) {
                    queue.add(currentNode.left);
                }
                else {
                    queue.add(currentNode.right);
                    highRs = currentNode;
                }
            }
            else {
                highRs = currentNode;
            }
        }
//        System.out.println(lowRs.data + " " + highRs.data);
//        System.out.println(super.rank(super.root, lowRs.data) + " " + super.rank(super.root, highRs.data));

        if (highRs.data.compareTo(low) >= 0 && highRs.data.compareTo(high) <= 0)
            return super.rank(super.root, highRs.data) - super.rank(super.root, lowRs.data) + 1;
        return super.rank(super.root, highRs.data) - super.rank(super.root, lowRs.data);
    }
}
