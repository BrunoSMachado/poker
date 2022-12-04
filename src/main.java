import pojos.Card;
import pojos.Hand;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int player1 = 0;
        try {
            File file = new File("C:\\Users\\bruno\\OneDrive\\Documentos\\git\\poker\\src\\files\\poker.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
                List<Card> cardList = new ArrayList<>();
                String[] cardArray = st.split(" ");
                for(String s: cardArray) {
                    Card card = new Card(s);
                    cardList.add(card);
                }
                List<Card> h1 = cardList.subList(0,5);
                Collections.sort(h1, (a,b) -> a.getValue() - b.getValue());
                List<Card> h2 = cardList.subList(5,10);
                Collections.sort(h2, (a,b) -> a.getValue() - b.getValue());
                Hand hand1 = new Hand(h1);
                Hand hand2 = new Hand(h2);
                hand1.setRank();
                hand2.setRank();
                if(hand1.compareHands(hand2) == 1) {
                    player1++;
                }
            }
            System.out.println("Number of times player1 own: " + player1);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
