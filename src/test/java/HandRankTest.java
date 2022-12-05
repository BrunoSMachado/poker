import helper.Helper;
import org.junit.Assert;
import org.junit.Test;
import pojos.Hand;

public class HandRankTest {

    @Test
    public void testRoyalStraightFLush() {
        String hand = "TC JC QC KC AC";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 9);
    }

    @Test
    public void testWheelStraightFLush() {
        String hand = "2C 3C 4C 5C AC";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 9);
    }

    @Test
    public void testFourOfAKind() {
        String hand = "KH KC KS KD AC";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 8);
        Assert.assertEquals(h1.getHighestSetCard(), 13);
    }

    @Test
    public void testFullHouse1() {
        String hand = "2H 2C AS AD AC";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 7);
        Assert.assertEquals(h1.getHighestSetCard(), 14);
        Assert.assertEquals(h1.getSndHighestCard(), 2);
    }

    @Test
    public void testFullHouse2() {
        String hand = "4H 4C 4S AD AC";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 7);
        Assert.assertEquals(h1.getHighestSetCard(), 4);
        Assert.assertEquals(h1.getSndHighestCard(), 14);
    }

    @Test
    public void testFlush() {
        String hand = "5H 4H TH KH AH";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 6);
    }

    @Test
    public void testStraight() {
        String hand = "5H 6H 7H 8H 9C";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 5);
    }

    @Test
    public void testWheelStraight() {
        String hand = "2H 3H 4H 5H AC";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 5);
    }

    @Test
    public void testThreeOfAKind() {
        String hand = "2H 3H 4S 4H 4C";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 4);
        Assert.assertEquals(h1.getHighestSetCard(), 4);
    }

    @Test
    public void testTwoPair() {
        String hand = "2H 2C 4S 4H AC";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 3);
        Assert.assertEquals(h1.getHighestSetCard(), 4);
        Assert.assertEquals(h1.getSndHighestCard(), 2);
    }

    @Test
    public void testPair() {
        String hand = "5H 5C 6S 7H 8C";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 2);
        Assert.assertEquals(h1.getHighestSetCard(), 5);
    }

    @Test
    public void testHighCard() {
        String hand = "2H 5C 6S 7H 8C";
        Hand h1 = Helper.createHand(hand);
        Assert.assertEquals(h1.getRank(), 1);
        Assert.assertEquals(h1.getNotMadeCards().size(), 5);
    }
}