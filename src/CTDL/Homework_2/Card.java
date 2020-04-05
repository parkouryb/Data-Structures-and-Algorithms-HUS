package CTDL.Homework_2;

public class Card implements Comparable<Card> {
    private String rank;
    private String suit;
    // clubs (♣), diamonds (♦), hearts (♥) and spades (♠)
    private String[] suits = {"Tep", "Gio", "Co", "Bich"};
    
    public Card() {
        this.rank = null;
        this.suit = null;
    }
    /**
     * Contructor
     * @param rank
     * @param suit
     */
    public Card(String rank, String suit)  {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    private int convertSuit(String suit) {
        int ans = 0;
        if (suit.equals("clubs") || suit.equals("Clubs")) ans = 1;
        if (suit.equals("diamonds") || suit.equals("Diamonds")) ans = 2;
        if (suit.equals("hearts") || suit.equals("Hearts")) ans = 3;
        if (suit.equals("spades") || suit.equals("Spades")) ans = 4;
        return ans;
    }

    private int convertRank(String rank) {
        int ans = 0;
        if (rank.equals("ace") || rank.equals("Ace")) ans = 1;
        if (rank.equals("2") || rank.equals("Two")) ans = 2;
        if (rank.equals("3") || rank.equals("Three")) ans = 3;
        if (rank.equals("4") || rank.equals("Four")) ans = 4;
        if (rank.equals("5") || rank.equals("Five")) ans = 5;
        if (rank.equals("6") || rank.equals("Six")) ans = 6;
        if (rank.equals("7") || rank.equals("Seven")) ans = 7;
        if (rank.equals("8") || rank.equals("Eight")) ans = 8;
        if (rank.equals("9") || rank.equals("Nine")) ans = 9;
        if (rank.equals("10") || rank.equals("Ten")) ans = 10;
        if (rank.equals("j") || rank.equals("J")) ans = 11;
        if (rank.equals("q") || rank.equals("Q")) ans = 12;
        if (rank.equals("k") || rank.equals("K")) ans = 13;
        return ans;
    }

    @Override
    public String toString() {
        return this.rank + "[" + this.suits[convertSuit(this.suit) - 1] + "]";
    }

    /**
     * @return 0 for equal
     * @return 1 for bigger
     * @return -1 for lesser
     */
    @Override
    public int compareTo(Card card) {
        // clubs (♣), diamonds (♦), hearts (♥) and spades (♠)
        // Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K
        // this list go on like clubs < diamonds < hearts < spades
        // (theo minh thi: spades < clubs < diamonds < hearts) 
        // compare follows line 62;
        int thisRank = convertRank(this.rank);
        int thisSuit = convertSuit(this.suit);
        int cardRank = convertRank(card.rank);
        int cardSuit = convertSuit(card.suit);

        if (thisSuit != cardSuit) {
            if (thisSuit < cardSuit) return -1;
            else return 1;
        }else {
            if (thisRank != cardRank) {
                if (thisRank < cardRank) return -1;
                else return 1;
            }
            else return 0;
        }
    }

}   