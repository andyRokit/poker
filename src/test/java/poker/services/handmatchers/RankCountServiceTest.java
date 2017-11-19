package poker.services.handmatchers;

import org.junit.Test;
import poker.model.PlayingCard;
import poker.model.PokerHand;
import poker.model.Rank;
import poker.model.Suit;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RankCountServiceTest {
    private RankCountService underTest = new RankCountService();

    @Test
    public void shouldCount() {
        final PokerHand testHand = new PokerHand(Arrays.asList(
                new PlayingCard(Rank.TWO, Suit.CLUBS),
                new PlayingCard(Rank.TWO, Suit.DIAMONDS),
                new PlayingCard(Rank.THREE, Suit.CLUBS),
                new PlayingCard(Rank.THREE, Suit.DIAMONDS),
                new PlayingCard(Rank.THREE, Suit.HEARTS)
        ));

        List<Integer> actual = underTest.countRanks(testHand);
        List<Integer> expected = Arrays.asList(2, 3);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void shouldCountUnordered() {
        final PokerHand testHand = new PokerHand(Arrays.asList(
                new PlayingCard(Rank.THREE, Suit.CLUBS),
                new PlayingCard(Rank.TWO, Suit.CLUBS),
                new PlayingCard(Rank.THREE, Suit.DIAMONDS),
                new PlayingCard(Rank.TWO, Suit.DIAMONDS),
                new PlayingCard(Rank.THREE, Suit.HEARTS)
        ));

        List<Integer> actual = underTest.countRanks(testHand);
        List<Integer> expected = Arrays.asList(2, 3);
        assertThat(actual, equalTo(expected));
    }
}
