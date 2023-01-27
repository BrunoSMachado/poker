package src;


import pojos.Card;
import pojos.Hand;

import java.util.ArrayList;
import java.util.List;

public class HandRankTest {

    public List<Card> createCards(String s) {
        List<Card> cardList = new ArrayList<>();
        String[] cardArray = s.split(" ");
        for(String str: cardArray) {
            Card card = new Card(str);
            cardList.add(card);
        }
        return cardList;
    }

    @Test
    public void testRoyalFLush() {
        String hand = "TC JC QC KC AC";
        List<Card> cardList = createCards(hand);
        Hand h1 = new Hand(cardList);
        h1.setRank();
    }
}
