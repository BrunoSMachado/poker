import helper.Helper;
import org.junit.Assert;
import org.junit.Test;
import pojos.Hand;

public class HandComparisonTest {

    @Test
    public void compareStraightFlushes() {
        String hand1 = "TC JC QC KC AC";
        String hand2 = "2H 3H 4H 5H AH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }

    @Test
    public void compareStraightFlushAndStraight() {
        String hand1 = "2H 3H 4H 5H AH";
        String hand2 = "TH JC QC KC AC";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }

    @Test
    public void compareStraightFlushAndFourOfKind() {
        String hand1 = "2H 3H 4H 5H AH";
        String hand2 = "TH TC TS TD AH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }

    @Test
    public void compareFourOfAKind1() {
        String hand1 = "TH TC TS TD JH";
        String hand2 = "TH TC TS TD AH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareFourOfAKind2() {
        String hand1 = "2H 2C 2S 2D AH";
        String hand2 = "TH TC TS TD JH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareFourOfAKindAndFullHouse() {
        String hand1 = "2H 2C 2S 2D AH";
        String hand2 = "TH TC TS JD JH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }
    @Test
    public void compareFullHouses1() {
        String hand1 = "2H 2C 2S AD AH";
        String hand2 = "TH TC TS JD JH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareFullHouses2() {
        String hand1 = "TH TC TS AD AH";
        String hand2 = "TH TC TS JD JH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }

    @Test
    public void compareFullHousesAndFlush() {
        String hand1 = "TH TC TS AD AH";
        String hand2 = "2H 5H 7H 9H JH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }

    @Test
    public void compareFlush1() {
        String hand1 = "2H 5H 8H TH AH";
        String hand2 = "2H 5H 8H 9H JH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }

    @Test
    public void compareFlush2() {
        String hand1 = "2H 5H 8H TH AH";
        String hand2 = "2H 5H 8H 9H AH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }

    @Test
    public void compareFlush3() {
        String hand1 = "3H 5H 8H TH AH";
        String hand2 = "2H 5H 8H TH AH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }

    @Test
    public void compareStraight1() {
        String hand1 = "2H 3H 4H 5H 6H";
        String hand2 = "3H 4H 5H 6H 7H";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareStraight2() {
        String hand1 = "2H 3H 4H 5H AH";
        String hand2 = "3H 4H 5H 6H 7H";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareStraight3() {
        String hand1 = "2H 3H 4H 5H 9H";
        String hand2 = "3H 4H 5H 6H 7H";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareThreeOfAKind1() {
        String hand1 = "2S 2H 2C 5H 9H";
        String hand2 = "2S 2H 2C 5H TH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareThreeOfAKind2() {
        String hand1 = "2S 2H 2C 6H TH";
        String hand2 = "2S 2H 2C 5H TH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }

    @Test
    public void compareTwoPairs1() {
        String hand1 = "2S 2H 3C 3H TH";
        String hand2 = "2S 2H 4C 4H TH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareTwoPairs2() {
        String hand1 = "2S 2H 4C 4H TH";
        String hand2 = "3S 3H 4C 4H TH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareTwoPairs3() {
        String hand1 = "2S 2H 4C 4H TH";
        String hand2 = "2S 2H 4C 4H JH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void comparePair1() {
        String hand1 = "2S 2H 5C 6H TH";
        String hand2 = "3S 3H 4C 5H JH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void comparePair2() {
        String hand1 = "2S 2H 5C 6H TH";
        String hand2 = "2S 2H 4C 6H TH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 1);
    }

    @Test
    public void comparePair3() {
        String hand1 = "2S 2H 5C 6H TH";
        String hand2 = "2S 2H 4C 6H AH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareHighCard1() {
        String hand1 = "2S 3H 5C 6H TH";
        String hand2 = "2S 3H 4C 6H AH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }

    @Test
    public void compareHighCard2() {
        String hand1 = "2H 4C 6H TH AH";
        String hand2 = "3H 4C 6H TH AH";
        Hand h1 = Helper.createHand(hand1);
        Hand h2 = Helper.createHand(hand2);
        Assert.assertTrue(h1.compareHands(h2) == 2);
    }
}
