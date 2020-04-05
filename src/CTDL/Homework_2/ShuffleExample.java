package CTDL.Homework_2;

import java.util.*;

public class ShuffleExample{
    public static void CardExample() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4"
                        , "5", "6", "7", "8", "9"
                        , "10", "J", "Q", "K"};

        // spawn a desk card
        // like NEW <3    
        Card[] deskCard = new Card[52];
        int index_suits = 0, index_ranks = 0;
        for (int i = 0;i < 52;++ i) {
            deskCard[i] = new Card(ranks[i % 13], suits[i / 13]);
        }

        int co = 0;
        for (Card x : deskCard) {
            System.out.print(x + " ");
            ++ co;
            if (co % 13 == 0) System.out.println("");
        }
        System.out.println("After shuffle: ");
        Shuffle shuffle = new Shuffle();
        shuffle.shuffle(deskCard);
        
        for (Card x : deskCard) {
            System.out.print(x + " ");
            ++ co;
            if (co % 13 == 0) System.out.println("");
        }
        
        System.out.println("After sort: ");
        GenericArray<Card> generic = new GenericArray<Card>(Card.class);
        generic.bubbleSort(deskCard);
        generic.printArray(deskCard);
    }

    public static void main(String[] agrs) {
        // Shuffle shuffle = new Shuffle();

        CardExample();
        // Integer[] a = new Integer[52];
        
        // a = shuffle.randomL(a, 52, 52);

        // int co = 0;
        // for (Integer x : a) {
        //     System.out.print(x + " ");
        //     ++ co;
        //     if(co % 10 == 0) System.out.println("");
        // }
        // shuffle.shuffle(a);
        // co = 0;
        // for (Integer x : a) {
        //     System.out.print(x + " ");
        //     ++ co;
        //     if(co % 10 == 0) System.out.println("");
        // }
        

    }
}