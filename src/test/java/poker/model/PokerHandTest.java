package poker.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import poker.ApplicationException;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PokerHandTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void shouldCreateFromString() {
        final PokerHand pokerHand = PokerHand.fromString("2C 4D 6C 8D TH");
        assertThat(pokerHand, equalTo(new PokerHand(Arrays.asList(
                new PlayingCard(Rank.TWO, Suit.CLUBS),
                new PlayingCard(Rank.FOUR, Suit.DIAMONDS),
                new PlayingCard(Rank.SIX, Suit.CLUBS),
                new PlayingCard(Rank.EIGHT, Suit.DIAMONDS),
                new PlayingCard(Rank.TEN, Suit.HEARTS)
        ))));
    }

    @Test
    public void shouldThrowExceptionWhenInvalidFormat() {
        expectedEx.expect(ApplicationException.class);
        expectedEx.expectMessage("Hand [2C 4D 6C 8D] does not contain 5 cards");
        PokerHand.fromString("2C 4D 6C 8D");
    }

    @Test
    public void shouldFormatToString() {
        final PokerHand pokerHand = new PokerHand(Arrays.asList(
                new PlayingCard(Rank.TWO, Suit.CLUBS),
                new PlayingCard(Rank.FOUR, Suit.DIAMONDS),
                new PlayingCard(Rank.SIX, Suit.CLUBS),
                new PlayingCard(Rank.EIGHT, Suit.DIAMONDS),
                new PlayingCard(Rank.TEN, Suit.HEARTS)
        ));

        assertThat(pokerHand.toString(), equalTo("2C 4D 6C 8D TH"));
    }
}
