/* NomNom created on 5/26/2020 inside the package - CTDL.Homework_7.AVLTree */

package CTDL.Homework_7.AVLTree;

import java.io.*;

public class AVLTreeExample {
    private static String fileName = "D:\\iTech\\Data-Structures-and-Algorithms-HUS" +
            "\\src\\CTDL\\Homework_7\\AVLTree\\input.txt";
    private static String outFile = "D:\\iTech\\Data-Structures-and-Algorithms-HUS\\src\\CTDL\\Homework_7\\AVLTree\\output.txt";
    private static String ticketFile = "D:\\iTech\\Data-Structures-and-Algorithms-HUS\\src\\CTDL\\Homework_7\\AVLTree\\ticket.txt";

    public static Ticket readTicket() {
        Ticket a = new Ticket();
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fr != null;
        BufferedReader br = new BufferedReader(fr);



        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

    public static Integer readFile() {
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fr != null;
        BufferedReader br = new BufferedReader(fr);

        Integer x = null;
        try {
            x = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return x;
    }

    public static void WriteFile(Ticket x) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert writer != null;
        BufferedWriter buffer = new BufferedWriter(writer);
        try {
            System.out.println("?");
            buffer.write(x.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            buffer.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AVLTree<Ticket, Integer> ticketAVLTree = new AVLTree<>();
        ticketAVLTree.addNode(new Ticket(1, "cot 1"));
        ticketAVLTree.addNode(new Ticket(2, "cot 1"));
        ticketAVLTree.addNode(new Ticket(3, "cot 1"));
        ticketAVLTree.addNode(new Ticket(5, "cot 1"));
        ticketAVLTree.addNode(new Ticket(0, "cot 1"));
        ticketAVLTree.addNode(new Ticket(4, "cot 1"));

//        ticketAVLTree.printTree();

        Integer x = readFile();
        System.out.println(x);
        WriteFile(ticketAVLTree.search(new Ticket(x)));
//        Ticket res = ticketAVLTree.search(new Ticket(3, ""));
//        System.out.println(res);
    }
}
