package CTDL.Homework_5;

import org.w3c.dom.css.Rect;

import java.security.cert.PolicyNode;

public class SlicingTree extends LinkedBinaryTree {
    private Node root;
    private int n = 0;

    public SlicingTree() {
    }

    /**
     * Create a floor plan consisting of a single basic rectangle.
     * @param E
     * @return
     */
    public Node<Rectangle> addRoot(Rectangle E) {
        if (!isEmpty()) {
            System.out.println("Tree not empty.");
            return root;
        }
        root = new Node<Rectangle>(E, null, null, null);
        return root;
    }

    /**
     * Horizontal cut Rectangle
     * cut from (bot, left) -> L(bot + size, left), R(top, left)
     * @param node
     * @param size
     */
    public void horizontalCut(Node<Rectangle> node, double size) {
        // make sure our rectangle can cut
        if (node.getLeft() == null && node.getRight() == null) {
            Rectangle node_rect = node.getElement();
            if (size >= node_rect.getWidth() || size <= 0) {
                System.out.println("Error: Can't do horizontal cut");
                return;
            }

            Rectangle node_left_rect = new Rectangle(
                Integer.toString(n + 1), node_rect.getA(), new Point(node_rect.getB().x, node_rect.getA().y + size)
            );

            Rectangle node_right_rect = new Rectangle(
                Integer.toString(n + 2), new Point(node_rect.getA().x, node_rect.getA().y + size), node_rect.getB()
            );

            node.getElement().setId("H");
//            node.getElement().setA(new Point(0, 0));
//            node.getElement().setB(new Point(0, 0));
            addLeft(node, node_left_rect);
            ++ n;
            addRight(node, node_right_rect);
            ++ n;
            System.out.println("Debug: HorizontalCut successful!");
        }
        else {
            System.out.println("Error: Can't do horizontal cut");
        }
    }

    public void verticalCut(Node<Rectangle> node, double size) {
        // make sure our rectangle can cut
        if (node.getLeft() == null && node.getRight() == null) {
            Rectangle node_rect = node.getElement();
            if (size >= node_rect.getHeight() || size <= 0) {
                System.out.println("Error: Can't do vertical cut");
                return;
            }

            Rectangle node_left_rect = new Rectangle(
                    Integer.toString(n + 1), node_rect.getA(), new Point(node_rect.getA().x + size, node_rect.getB().y)
            );

            Rectangle node_right_rect = new Rectangle(
                    Integer.toString(n + 2), new Point(node_rect.getA().x + size, node_rect.getA().y), node_rect.getB()
            );

            node.getElement().setId("V");
//            node.getElement().setA(new Point(0, 0));
//            node.getElement().setB(new Point(0, 0));

            addLeft(node, node_left_rect);
            ++ n;
            addRight(node, node_right_rect);
            ++ n;
            System.out.println("Debug: verticalCut successful!");
        }
        else {
            System.out.println("Error: Can't do vertical cut");
        }
    }

    public Rectangle assignTree(Node<Rectangle> p) {
        if (p.getElement() == null) {
            return null;
        }
        if (p.getLeft() == null && p.getRight() == null) {
            return p.getElement();
        }

        Rectangle p_left = assignTree(p.getLeft());
        Rectangle p_right = assignTree(p.getRight());

        Point p_a = p_left.getA();
        Point p_b = p_right.getB();

        p.getElement().setA(p_a);
        p.getElement().setB(p_b);

        return p.getElement();

    }
}
