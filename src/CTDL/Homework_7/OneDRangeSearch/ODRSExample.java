/* NomNom created on 5/29/2020 inside the package - CTDL.Homework_7.OneDRangeSearch */

package CTDL.Homework_7.OneDRangeSearch;

public class ODRSExample {
    public static void main(String[] args) {
        ODRS tree = new ODRS();
//        tree.addNode("B");
//        tree.addNode("D");
//        tree.addNode("A");
//        tree.addNode("I");
//        tree.addNode("H");
//        tree.addNode("F");
//        tree.addNode("P");
//        tree.printTree();
//        System.out.println("------------------");
//        tree.search("G", "K");
//        System.out.println(tree.count("G", "K"));
//        tree.delNode("D");
//        tree.printTree();
//        tree.search("A", "Z");
//        System.out.println(tree.count("A", "Z"));
        tree.addNode("S");
        tree.addNode("X");
        tree.addNode("E");
        tree.addNode("A");
        tree.addNode("R");
        tree.addNode("C");
        tree.addNode("H");
        tree.addNode("M");
        tree.addNode("L");
        tree.addNode("P");
        tree.printTree();
        tree.search("F", "T");
        System.out.println("Count F to T: " +  tree.count("F", "T"));
        tree.delNode("X");
        tree.delNode("L");
        tree.delNode("A");
        tree.printTree();
        tree.search("F", "T");
    }
}
