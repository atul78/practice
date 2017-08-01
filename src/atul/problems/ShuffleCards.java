package atul.problems;

/**
 * Created by agosain on 6/30/2017.
 */
public class ShuffleCards {
    public static int getRandom(int start, int end){
        return start+(int)(Math.random()*(end-start+1));
    }
    public static void shuffleIter(int[] cards){
        for (int i=0;i<cards.length;i++){
            int k = getRandom(0,i);
            int temp = cards[i];
            cards[i] = cards[k];
            cards[k] = temp;
        }
    }

    public static void shuffleCards(int[] cards, int i){
        if(i==0) return ;

        int k = getRandom(0,i);

        // swap cards[i] with cards[k]
        System.out.println("Swapping "+i+" with "+k);
        int temp = cards[i];
        cards[i] = cards[k];
        cards[k] = temp;

        shuffleCards(cards, i-1);

    }

    public static int[] getCards(){
        int[] cards = new int[52];
        for(int i=0;i<52;i++)
            cards[i] = i;

        return cards;
    }

    public static void print(int[] cards){
        for(int card : cards)
            System.out.print(card+",");

        System.out.println();
    }
    public static void main(String args[]){
        int[] cards = getCards();
        shuffleIter(cards);
        print(cards);
    }
}
