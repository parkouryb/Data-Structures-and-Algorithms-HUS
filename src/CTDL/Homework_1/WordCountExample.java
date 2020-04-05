package CTDL.Homework_1;

import java.util.*;
import java.io.*;

public class WordCountExample{

    public static void main(String[] agrs) throws Exception {
        SimpleArrayList<WordCount> WordCounts = new SimpleArrayList<>();
        FileReader fr = new FileReader("file.txt");
        BufferedReader br = new BufferedReader(fr);
        
        int data;
        String tmp = "";
        while ((data = br.read()) != -1) {
            if (data == (int)(' ')) {
                WordCount x = new WordCount(tmp);
                if (WordCounts.isContain(x)) {
                    int index = WordCounts.indexOf(x);
                    x = WordCounts.get(index);
                    x.setCount(x.getCount() + 1);
                    WordCounts.set(index, x);
                }
                else {
                    WordCounts.add(x);
                }
                tmp = "";
            }
            else {
                tmp = tmp + (char)data;
            }
        }
        br.close();
        fr.close();

        for (WordCount x : WordCounts) {
            System.out.println(x.toString());
        }
    }
}