package CTDL.Homework_3;

public class SimpleLinkedListExample{
    public static void main(String[] agrs){
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(51212);
        linkedList.add(2);
        linkedList.add(511);
        linkedList.addBot(511111111);
        linkedList.addBot(51111111);
        linkedList.addBot(51212);
        linkedList.display();
        System.out.println("");

        linkedList.set(5, 121);
        linkedList.set(1, 1121);
        
        linkedList.display();
        System.out.println("");
        System.out.println("size: " + linkedList.size());
        System.out.println("Get value: " + linkedList.get(6));
        System.out.println("isEmpty: " + linkedList.isEmpty());
        System.out.println("isContain: " + linkedList.isContain(0001));
        
        linkedList.remove(51212);
        linkedList.display();
        System.out.println(" + " + linkedList.size());
        
    }
}