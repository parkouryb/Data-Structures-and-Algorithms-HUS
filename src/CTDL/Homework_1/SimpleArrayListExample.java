package CTDL.Homework_1;

public class SimpleArrayListExample {
    public static void main(String[] agrs) {
        SimpleArrayList<Integer> arrayList = new SimpleArrayList<Integer>(6);
        arrayList.add(4);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(55);
        arrayList.add(2);
        arrayList.add(4);

        // SimpleArrayList<Integer> arrayList1 = arrayList.iterator();
        
        System.out.println(arrayList.iterator().next());
        
    }
}