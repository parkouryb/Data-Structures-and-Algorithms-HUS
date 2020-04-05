package CTDL.Homework_2;

import java.util.*;
import java.lang.*; 
import java.io.*; 

public class CardExample{

    public static void main(String[] agrs) {
        Card[] Cards = new Card[4];
        Cards[0] = new Card("2", "Hearts");
        Cards[1] = new Card("Ace", "Hearts");
        Cards[2] = new Card("J", "Spades");
        Cards[3] = new Card("K", "Diamonds");
        
        Arrays.sort(Cards); // day

        for (Card x : Cards) {
            System.out.print(x.toString() + " ");
        }
        System.out.println("");

        // GenericArray<Card> generic = new GenericArray<Card>(Card.class, 4);
        // Card[] myArray = generic.getMyArray();

        // myArray[0] = new Card("2", "Hearts");
        // myArray[1] = new Card("Ace", "Hearts");
        // myArray[2] = new Card("J", "Spades");
        // myArray[3] = new Card("K", "Diamonds");

        // generic.printArray(myArray);

        // generic.bubbleSort(myArray);

        // generic.printArray(myArray);

    }
}