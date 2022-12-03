package pojos;

import java.util.*;
import java.util.stream.Collectors;

public class Hand {
    List<Card> cards;
    Map<Integer, Integer> numberOfCards;
    int rank;
    int highestSetCard;
    int sndHighestSetCard;
    List<Integer> notMadeCards;

    public Hand(List<Card> cards) {
        this.cards = cards;
        this.highestSetCard = 0;
        this.sndHighestSetCard = 0;
        this.numberOfCards = new HashMap<>();
        for(Card card: this.cards) {
            Integer value = numberOfCards.get(card.getValue());
            if(value == null) {
                numberOfCards.put(card.getValue(), 1);
            }
            else {
                numberOfCards.put(card.getValue(), ++value);
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getHighestSetCard() {
        return highestSetCard;
    }

    public void setHighestSetCard(int highestSetCard) {
        this.highestSetCard = highestSetCard;
    }

    public List<Integer> getNotMadeCards() {
        return notMadeCards;
    }

    public void setNotMadeCards(List<Integer> notMadeCards) {
        this.notMadeCards = notMadeCards;
    }

    public int getSndHighestCard() {
        return sndHighestSetCard;
    }

    public void setSndHighestCard(int sndHighestCard) {
        this.sndHighestSetCard = sndHighestCard;
    }

    public boolean isRoyalFlush() {
        String suit = cards.get(0).getSuit();
        Integer value = cards.get(0).getValue();
        for(int i = 1; i< cards.size(); i++) {
            if(!suit.equals(cards.get(i)) || cards.get(i).getValue() != ++value) {
                return false;
            }
            // case for when the straight starts with an Ace
            if(i == 3 && cards.get(3).getValue() == 5 && cards.get(3).getSuit().equals(suit) &&
                    cards.get(4).getValue() == 14 && cards.get(4).getSuit().equals(suit)) {
                setRank(9);
                setHighestSetCard(5);
                return true;
            }
        }
        setRank(9);
        setHighestSetCard(cards.get(4).getValue());
        return true;
    }

    public boolean isFourOfAKind() {
        boolean fourOfaKind = false;
        List<Integer> notMadeCards = new ArrayList<>();
        for(Integer key: this.numberOfCards.keySet()) {
            Integer keyValue = this.numberOfCards.get(key);
            if(keyValue == 4) {
                fourOfaKind = true;
                setRank(8);
                setHighestSetCard(keyValue);
            }
            else {
                notMadeCards.add(key);
            }
        }
        if(fourOfaKind) {
            setNotMadeCards(notMadeCards);
            return true;
        }
        return false;
    }

    public boolean isFullHouse() {
        Map<Integer, Integer> map = new HashMap<>();
        int highestCard = 0;
        int secondHighestCard = 0;
        for(Integer key: map.keySet()) {
            Integer keyValue = map.get(key);
            if(keyValue == 3) {
                highestCard = key;
            }
            else if(keyValue == 2) {
                secondHighestCard = 2;
            }
        }
        if(highestCard != 0 && secondHighestCard != 0) {
            setRank(7);
            setHighestSetCard(highestCard);
            setSndHighestCard(secondHighestCard);
            return true;
        }
        return false;
    }

    public boolean isFlush() {
        String suit = cards.get(0).getSuit();
        for(int i = 1; i< cards.size(); i++) {
            if(!suit.equals(cards.get(i))) {
                return false;
            }
        }
        setRank(6);
        return true;
    }

    public boolean isStraight() {
        Integer value = cards.get(0).getValue();
        for(int i = 1; i< cards.size(); i++) {
            if(cards.get(i).getValue() != ++value) {
                return false;
            }
            // case for when the straight starts with an Ace
            if(i == 3 && cards.get(3).getValue() == 5 && cards.get(4).getValue() == 14) {
                setRank(5);
                setHighestSetCard(5);
                return true;
            }
        }
        setRank(5);
        setHighestSetCard(cards.get(4).getValue());
        return true;
    }

    public boolean isThreeOfAKind() {
        boolean threeOfAKing = false;
        List<Integer> notMadeCards = new ArrayList<>();
        for(Integer key: this.numberOfCards.keySet()) {
            Integer keyValue = this.numberOfCards.get(key);
            if(keyValue == 3) {
                threeOfAKing = true;
                setRank(4);
                setHighestSetCard(keyValue);
            }
            else {
                notMadeCards.add(key);
            }
        }
        if(threeOfAKing) {
            setNotMadeCards(notMadeCards);
            return true;
        }
        return false;
    }

    public boolean isTwoPairs() {
        int numberOfPairs = 0;
        int highestPairCard = 0;
        int sndPairCard = 0;
        List<Integer> notMadeCards = new ArrayList<>();
        for(Integer key: this.numberOfCards.keySet()) {
            Integer keyValue = this.numberOfCards.get(key);
            if(keyValue == 2) {
                numberOfPairs++;
                if(key > highestPairCard && sndPairCard == 0) {
                    highestPairCard = key;
                }
                else if(key > highestPairCard && sndPairCard != 0) {
                    sndPairCard = highestPairCard;
                    highestPairCard = key;
                }
                else if(key < highestPairCard && key > sndPairCard) {
                    sndPairCard = key;
                }
            }
            else {
                notMadeCards.add(key);
            }
        }
        if(numberOfPairs == 2) {
            setRank(3);
            setHighestSetCard(highestPairCard);
            setSndHighestCard(sndPairCard);
            setNotMadeCards(notMadeCards);
            return true;
        }
        return false;
    }

    public boolean isPair() {
        int pairCard =0;
        List<Integer> notMadeCards = new ArrayList<>();
        for(Integer key: this.numberOfCards.keySet()) {
            Integer keyValue = this.numberOfCards.get(key);
            if(keyValue == 2) {
                pairCard = key;
            }
            else {
                notMadeCards.add(key);
            }
        }
        if(pairCard != 0) {
            setRank(2);
            setHighestSetCard(pairCard);
            setNotMadeCards(notMadeCards);
            return true;
        }
        return false;
    }
    public void setRank() {
        if(!isRoyalFlush()) {
            if(!isFourOfAKind()) {
                if(!isFullHouse()) {
                    if(!isFlush()) {
                        if(!isStraight()) {
                            if(!isThreeOfAKind()) {
                                if(!isTwoPairs()) {
                                    if(!isPair()) {
                                        setNotMadeCards(this.cards.stream().map(Card::getValue).collect(Collectors.toList()));
                                        setRank(1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Integer compareHands(Hand hand2) {
        if(this.getRank() > hand2.getRank()) {
            return 1;
        }
        else if(this.getRank() < hand2.getRank()) {
            return 2;
        }
        else {
            if(this.getHighestSetCard() > hand2.getHighestSetCard()) {
                return 1;
            }
            else if(this.getHighestSetCard() < hand2.getHighestSetCard()) {
                return 2;
            }
            else {
                if(this.getSndHighestCard() > hand2.getSndHighestCard()) {
                    return 1;
                }
                else if(this.getSndHighestCard() < hand2.getSndHighestCard()) {
                    return 2;
                }
                else {
                    return this.compareNotMadeCards(hand2);
                }
            }
        }
    }

    public Integer compareNotMadeCards(Hand hand2) {
        for(int i = this.getNotMadeCards().size() -1; i >= 0; i++) {
            if(this.getNotMadeCards().get(i) > hand2.getNotMadeCards().get(i)) {
                return 1;
            }
            else if(this.getNotMadeCards().get(i) < hand2.getNotMadeCards().get(i)) {
                return 2;
            }
        }
        return null;
    }
}
