package CTDL.Homework_3;

import java.util.*;
import java.io.*;

public class WordCount{
    private String word = null;
    private int count = 0;

    public WordCount(String word) {
        this.word = word;
        this.count = 1;
    }
    
    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public boolean equals(Object x) {
        WordCount other = (WordCount) x;
        return this.word.equals(other.word);
    }

    @Override
    public String toString() {
        return "Word: '" + this.word + "'. Count: " + this.count + "\n";
    }
}