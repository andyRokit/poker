package poker.services.handmatchers;

import org.junit.Test;
import poker.model.PokerHand;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FlushMatchingServiceTest {
    private FlushMatchingService underTest = new FlushMatchingService();

    @Test
    public void shouldReturnCorrectDescription() {
        assertThat(underTest.description(), equalTo("Flush"));
    }

    @Test
    public void shouldReturnTrueWhenFlushExists() {
        final PokerHand testHand = PokerHand.fromString("2C 4C 6C 8C TC");
        assertThat(underTest.matches(testHand), is(true));
    }

    @Test
    public void shouldReturnFalseWhenNoFlushExists() {
        final PokerHand testHand = PokerHand.fromString("2C 4D 6C 8D TH");
        assertThat(underTest.matches(testHand), is(false));
    }
}
