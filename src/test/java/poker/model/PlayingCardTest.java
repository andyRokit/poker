package poker.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import poker.ApplicationException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayingCardTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void shouldCreateFromString() {
        final PlayingCard playingCard = PlayingCard.fromString("3H");
        assertThat(playingCard.getRank(), is(Rank.THREE));
        assertThat(playingCard.getSuit(), is(Suit.HEARTS));
    }

    @Test
    public void shouldThrowExceptionWhenInvalidFormat() {
        expectedEx.expect(ApplicationException.class);
        expectedEx.expectMessage("Not a valid card format: XXX");
        PlayingCard.fromString("XXX");
    }

    @Test
    public void shouldFormatToString() {
        final PlayingCard playingCard = new PlayingCard(Rank.THREE, Suit.HEARTS);
        assertThat(playingCard.toString(), equalTo("3H"));
    }
}
