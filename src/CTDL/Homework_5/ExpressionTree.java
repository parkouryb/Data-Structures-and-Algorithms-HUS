package CTDL.Homework_5;

import java.util.Stack;

public class ExpressionTree<E> extends LinkedBinaryTree {

    private void preorder_race(Node<E> p) {
        if (p == null) return;
        System.out.print(p.getElement() + " ");
        preorder_race(p.getLeft());
        preorder_race(p.getRight());
    }

    public void preoderPrint(Node<E> p) {
        // (Root, Left, Right)
        System.out.print("Preorder (Root, Left, Right): ");
        preorder_race(p);
        System.out.println("");
    }

    public void postorderPrint(Node<E> p) {
        // (Left, Right, Root)
        System.out.print("Postorder (Left, Right, Root): ");
        postorder_race(p);
        System.out.println("");
    }

    private void postorder_race(Node<E> p) {
        if (p == null) return;
        postorder_race(p.getLeft());
        postorder_race(p.getRight());
        System.out.print(p.getElement() + " ");
    }

    private void inorder_race(Node<E> p) {
        if (p == null) {
            return;
        }
        if (p.getRight() != null && p.getLeft() != null)
            System.out.print("(");
        inorder_race(p.getLeft());
        if (p.getElement() == "*" || p.getElement() == "/"
                || p.getElement() == "+" || p.getElement() == "-")
            System.out.print(" " + p.getElement() + " ");
        else System.out.print(p.getElement());
        inorder_race(p.getRight());
        if (p.getRight() != null && p.getLeft() != null)
            System.out.print(")");
    }

    public void inorderPrint(Node<E> p) {
        // (Left, Root, Right)
        System.out.print("Inorder (Left, Root, Right): ");
        inorder_race(p);
        System.out.println("");
    }

    boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }

    /**
     * Constuct Binary Tree by String postfix
     * @param postfix
     * @return Node Root
     */
    public Node<E> constructTree(String postfix) {
        Stack <Node<E>> stack = new Stack<>();
        Node<E> t, t1, t2;
        String num = "";
        char[] charArray = postfix.toCharArray();
        for (int i = 0;i < charArray.length;++ i) {
            if (!isOperator(charArray[i])) {
                if (charArray[i] == '(') {
                    num = "";
                    continue;
                }
                else {
                    if (charArray[i] == ')') {
                        // push stack
                        t = (Node<E>) new Node<String>(num, null, null, null);
                        stack.push(t);
                        num = "";
                    }
                    else {
                        num += charArray[i];
                    }
                }
            }
            else {
                t = (Node<E>) new Node<String>(Character.toString(charArray[i]), null, null, null);
                t1 = stack.pop();
                t2 = stack.pop();

                t.setRight(t1);
                t.setLeft(t2);

                stack.push(t);
            }
        }

        t = stack.peek();
        stack.pop();
        return t;
    }

    /**
     * Get sum of Binary Tree
     * @param p
     * @return
     */
    public double Evalution_Of_Tree(Node<E> p) {
        if (p == null) {
            return 0;
        }
        if (p.getLeft() == null && p.getRight() == null) {
//            System.out.println("leaf: " + toInt((String)p.getElement()));
            return Double.parseDouble((String)p.getElement());
        }
        double l_val = Evalution_Of_Tree(p.getLeft());
        double r_val = Evalution_Of_Tree(p.getRight());
        double sum = 0;
        if (p.getElement().equals("+")) sum = l_val + r_val;
        if (p.getElement().equals("-")) sum = l_val - r_val;
        if (p.getElement().equals("*")) sum = l_val * r_val;
        if (p.getElement().equals("/")) sum = (double) (l_val / r_val);

//        System.out.println(l_val + " " + r_val + " " + sum);
        return sum;

    }

    int precedence(char c) {
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public String infix_prefix(String expression) {
        String result = "";

        return result;
    }

    public String infix_postfix(String expression) {
        String result = "";
        Stack <Character> stack = new Stack<Character>();
        String num = "";
        for (int i = 0;i < expression.length();++ i) {
            char c = expression.charAt(i);
            if (c == ' ') continue;
            if (precedence(c) > 0) {
                // if char is operator
                if (!num.equals("")) {
                    result += "(" + num + ")";
                }
                num = "";
                while (!stack.empty() && precedence(stack.peek()) >= precedence(c)) {
                    result += stack.pop();
                }
                stack.push(c);
            } else {
                if (c == ')') {
                    if (!num.equals("")) {
                        result += "(" + num + ")";
                    }
                    num = "";
                    // close bracket
                    char x = stack.pop();
                    while (x != '(') {
                        result += x;
                        x = stack.pop();
                    }

                }
                else {
                    if (c == '(') {
                        // open bracket
                        num = "";
                        stack.push(c);
                    }
                    else {
                        // number
                        num += c;
                    }

                }

            }

        }
        while (!stack.empty()) {
            result += stack.pop();
        }
        return result;
    }
}