package CTDL.Homework_2;

public class GenericArrayExample{

    public static void main(String[] agrs) {

        GenericArray<String> generic = new GenericArray<String>(String.class, 5);
        String[] myArray = generic.getMyArray();
        myArray[0] = "Ha hieu";
        myArray[1] = "ha hieu";
        myArray[2] = "cc";
        myArray[3] = "X";
        myArray[4] = "A";

        generic.bubbleSort(myArray);
        
        generic.printArray(myArray);
    }
}