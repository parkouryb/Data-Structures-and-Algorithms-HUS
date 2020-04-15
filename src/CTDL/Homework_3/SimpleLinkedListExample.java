package CTDL.Homework_3;

public class SimpleLinkedListExample{
    public static void main(String[] agrs){
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(5);
        linkedList.add(5);
        linkedList.add(5);

        linkedList.addBot(1);
        linkedList.addBot(1);
        linkedList.addBot(1);
        linkedList.addBot(51212);
        linkedList.addBot(51212);
        linkedList.addBot(51212);
        linkedList.addBot(51212);
        linkedList.display();
        System.out.println("");

//        linkedList.set(5, 121);
//        linkedList.set(1, 1121);

        linkedList.display();
        System.out.println("size: " + linkedList.size());
        linkedList.remove(5);
        linkedList.display();

        System.out.println("size: " + linkedList.size());
        linkedList.remove(51212);
        linkedList.display();
        System.out.println("size: " + linkedList.size());

        linkedList.remove(1);
        linkedList.display();
        System.out.println("size: " + linkedList.size());
//        System.out.println("");
//        System.out.println("size: " + linkedList.size());
////        System.out.println("Get value: " + linkedList.get(6));
//        System.out.println("isEmpty: " + linkedList.isEmpty());
//        System.out.println("isContain: " + linkedList.isContain(0001));
//
//        linkedList.remove(55);
//        linkedList.display();
//        System.out.println(" + " + linkedList.size());

    }
}