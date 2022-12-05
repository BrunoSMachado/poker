package pojos;

public class Card {
    private int value;
    private String suit;

    public Card(String s) {
        String[] array = s.split("");
        String value = array[0];
        String suit = array[1];
        switch(value) {
            case "T":
                this.value = 10;
                break;
            case "J": {
                this.value = 11;
                break;
            }
            case "Q": {
                this.value = 12;
                break;
            }
            case "K": {
                this.value = 13;
                break;
            }
            case "A": {
                this.value = 14;
                break;
            }
            default: {
                this.value = Integer.valueOf(value);
            }
        }
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit='" + suit + '\'' +
                '}';
    }
}



