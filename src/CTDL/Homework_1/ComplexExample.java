package CTDL.Homework_1;

public class ComplexExample{
    public static void main(String[] agrs) {
        ComplexNumbers x = new ComplexNumbers(-1, -4);
        ComplexNumbers y = new ComplexNumbers(3, -2);
        
        System.out.println("Plus: " + x.plus(y).toString());
        System.out.println("Multi: " + x.multi(y).toString());
        
    }
}