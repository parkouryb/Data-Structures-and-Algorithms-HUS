package CTDL.Homework_3;

public class LinkedList<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node top = null;
    private Node bot = null; // bo qua
    private int n = 0; 

    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public void add(T data) {
        // them phan tu vao dau  
        ++ n;
        Node temp = new Node(data);
        if (top == null) {
            top = temp;
            bot = temp;
        }
        else {
            // co n phan tu 
            // head -> Node khac.
            temp.next = top;
            top = temp;
        }
    }

    public void addBot(T data) {
        ++ n;
        Node temp = new Node(data);
        if (bot == null) { // truong hop ma list rong
            top = temp;
            bot = temp;
        }
        else { // truong hop list != rong
            temp.next = null;
            bot.next = temp;
            bot = temp;
        }
    }

    public T get(int i) {
        return null;
    }

    public void set(int i, T data) {
    }

    public boolean isContain(T data) {

        return false;

    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {

        return (n == 0);

    }

    public T removeTop() {
        if (top == null) {
            return null;
        } 
        else {
            
            if (n == 1) {
                T res = top.data;
                top = null;
                -- n;
                return res;
            }
            else {
                T res = top.data;
                Node temp = top.next;
                top = temp;
                -- n;
                return res;
            }
        }
    }

    public T removeBot() {
        if (bot == null) {
            return null;
        }
        else {
            if (n == 1) {
                T res = bot.data;
                -- n;
                bot = null;
                top = null;
                return res;
            }
            else {
                T res = bot.data;
                -- n;
                Node temp = top;
                while (temp.next.next != null) {
                    temp = temp.next;
                    
                }
                // System.out.println(temp.data + " " + bot.data + " " + bot.next);
                bot = temp;
                temp.next = null;
                return res;

            }
        }
    }

    public void remove(T data) {
        Node pointer = top;
        // nếu mà trường hợp có 1 phần tử mà trùng data -> removeTop();
        //                                khác data -> giữ nguyên
        // nếu mà có 2 phần tử trở lên: chừng nào mà phần tử đầu = data -> removeTop()
        //                         khác -> kiểm tra data của thằng next
        
    }
}