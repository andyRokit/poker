package services.handmatchers;

import org.junit.Test;
import poker.model.PokerHand;
import poker.services.handmatchers.HighCardMatchingService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HighCardMatchingServiceTest {
    private HighCardMatchingService underTest = new HighCardMatchingService();

    @Test
    public void shouldReturnCorrectDescription() {
        assertThat(underTest.description(), equalTo("High card"));
    }

    @Test
    public void shouldAlwaysReturnTrue() {
        final PokerHand testHand = PokerHand.fromString("2C 4D 6C 8D TH");
        assertThat(underTest.matches(testHand), is(true));
    }
}
