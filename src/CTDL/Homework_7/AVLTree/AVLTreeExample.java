/* NomNom created on 5/26/2020 inside the package - CTDL.Homework_7.AVLTree */

package CTDL.Homework_7.AVLTree;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        AVLTree<Ticket> ticketAVLTree = new AVLTree<>();
        Queue<String> places = new LinkedList<>();
        places.add("cot 1");
        places.add("cot 2");
        places.add("cot 3");
        places.add("cot 4");
        places.add("cot 5");

        {
            String place = places.remove();
            ticketAVLTree.addNode(new Ticket(1, place, "21-xxxx", "12312312", "04/02/2000", "ha trung hieu", "0915xxxxxx", "phuong nga", "0999xxxxxxx", "tp ho chi minh", "27/09/2001"));
        }
        {
            String place = places.remove();
            ticketAVLTree.addNode(new Ticket(2, place, "21-xxxx", "12312312", "04/02/2000", "ha trung hieu", "0915xxxxxx", "phuong nga", "0999xxxxxxx", "tp ho chi minh", "27/09/2001"));
        }

        System.out.println(places.size());

//        ticketAVLTree.addNode(new Ticket(3, "cot 341", "21-xxxx", "12312312", "04/02/2000", "ha trung hieu", "0915xxxxxx", "phuong nga", "0999xxxxxxx", "tp ho chi minh", "27/09/2001"));
//        ticketAVLTree.addNode(new Ticket(5, "cot 231", "21-xxxx", "12312312", "04/02/2000", "ha trung hieu", "0915xxxxxx", "phuong nga", "0999xxxxxxx", "tp ho chi minh", "27/09/2001"));
//        ticketAVLTree.addNode(new Ticket(0, "cot 545", "21-xxxx", "12312312", "04/02/2000", "ha trung hieu", "0915xxxxxx", "phuong nga", "0999xxxxxxx", "tp ho chi minh", "27/09/2001"));
//        ticketAVLTree.addNode(new Ticket(88, "cot 999", "21-xxxx", "12312312", "04/02/2000", "ha trung hieu", "0915xxxxxx", "phuong nga", "0999xxxxxxx", "tp ho chi minh", "27/09/2001"));

        ticketAVLTree.printTree();
        {
            Ticket x = ticketAVLTree.search(ticketAVLTree.root, new Ticket(1));
            ticketAVLTree.delNode(new Ticket(1));
            places.add(x.getDiadiem());
        }

        System.out.println(places.size());
        ticketAVLTree.printTree();

//        Integer x = readFile();
//        System.out.println(x);
//        WriteFile(ticketAVLTree.search(ticketAVLTree.root, new Ticket(x)));
//
//        Ticket res = ticketAVLTree.search(ticketAVLTree.root, new Ticket(3));
//        System.out.println(res);
//
//        System.out.println(ticketAVLTree.n);
    }
}
