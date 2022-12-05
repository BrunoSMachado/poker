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


    public boolean setRankArray() {
        String suit = this.cards.get(0).getSuit();
        Integer value = this.cards.get(0).getValue();
        boolean flush = true;
        boolean straight = true;
        for(int i=1; i< cards.size(); i++) {
            if(!suit.equals(cards.get(i).getSuit()) && !straight) {
                return false;
            }
            else if(!suit.equals(cards.get(i).getSuit()) && straight) {
                flush = false;
            }
            if(cards.get(i).getValue() != ++value && !flush) {
                return false;
            }
            else if(cards.get(i).getValue() != value && flush) {
                straight = false;
            }
            // wheel straight flush
            if(i == 3 && cards.get(3).getValue() == 5 && cards.get(3).getSuit().equals(suit) &&
                    cards.get(4).getValue() == 14 && cards.get(4).getSuit().equals(suit)) {
                setRank(9);
                setHighestSetCard(5);
                return true;
            }
            else if(i == 3 && cards.get(3).getValue() == 5 && cards.get(4).getValue() == 14) {
                setRank(5);
                setHighestSetCard(5);
                return true;
            }
        }
        if(flush && straight) {
            setRank(9);
            setHighestSetCard(cards.get(4).getValue());
            return true;
        }
        else if(flush && !straight) {
            setRank(6);
            setHighestSetCard(cards.get(4).getValue());
            return true;
        }
        else if(straight && !flush) {
            setRank(5);
            setHighestSetCard(cards.get(4).getValue());
            return true;
        }
        else {
            setNotMadeCards(this.cards.stream().map(Card::getValue).collect(Collectors.toList()));
            return false;
        }
    }

    public boolean setRankMap() {
        List<Integer> notMadeCards = new ArrayList<>();
        int pair = 0;
        int threeOfAKind = 0;
        for(Integer key: this.numberOfCards.keySet()) {
            Integer keyValue = this.numberOfCards.get(key);
            if(keyValue == 4) {
                setRank(8);
                setHighestSetCard(key);
            }
            else if(keyValue == 3) {
                if(pair!= 0) {
                    setRank(7);
                    setHighestSetCard(key);
                    setSndHighestCard(pair);
                }
                else {
                    threeOfAKind = key;
                }
            }
            else if(keyValue == 2) {
                if(threeOfAKind != 0) {
                    setRank(7);
                    setHighestSetCard(threeOfAKind);
                    setSndHighestCard(key);
                }
                else if(pair != 0) {
                    setRank(3);
                    setHighestSetCard(Math.max(key, pair));
                    setSndHighestCard(Math.min(key, pair));
                }
                else if(pair == 0) {
                    pair = key;
                }
            }
            else if(keyValue == 1) {
                notMadeCards.add(key);
            }
        }
        setNotMadeCards(notMadeCards);
        if(getRank() == 0) {
            if(pair != 0) {
                setRank(2);
                setHighestSetCard(pair);
            }
            else if(threeOfAKind != 0) {
                setRank(4);
                setHighestSetCard(threeOfAKind);
            }
            else {
                return false;
            }
        }
        return true;
    }

    public void setRank() {
        if(!setRankArray()) {
            if(!setRankMap()) {
                setRank(1);
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
