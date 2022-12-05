package helper;

import pojos.Card;
import pojos.Hand;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<Card> createCards(String s) {
        List<Card> cardList = new ArrayList<>();
        String[] cardArray = s.split(" ");
        for (String str : cardArray) {
            Card card = new Card(str);
            cardList.add(card);
        }
        return cardList;
    }

    public static Hand createHand(String s) {
        List<Card> cardList1 = Helper.createCards(s);
        Hand h1 = new Hand(cardList1);
        h1.setRank();
        return h1;
    }
}
