package CTDL.Homework_3;

public class LinkedListExample{

    public static void main(String[] agrs) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        System.out.println("Demo");
        linkedList.addBot(10);
        linkedList.addBot(20);
        linkedList.addBot(15);
        linkedList.display();

        linkedList.remove(10);
        linkedList.display();        
    }
}