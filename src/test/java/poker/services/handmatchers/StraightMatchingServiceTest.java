package poker.services.handmatchers;

import org.junit.Test;
import poker.model.PokerHand;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StraightMatchingServiceTest {
    private StraightMatchingService underTest = new StraightMatchingService();

    @Test
    public void shouldReturnCorrectDescription() {
        assertThat(underTest.description(), equalTo("Straight"));
    }

    @Test
    public void shouldReturnTrueWhenStraightExists() {
        final PokerHand testHand = PokerHand.fromString("2C 3D 4C 5D 6H");
        assertThat(underTest.matches(testHand), is(true));
    }

    @Test
    public void shouldReturnTrueWhenUnorderedStraightExists() {
        final PokerHand testHand = PokerHand.fromString("3D 4C 5D 6H 2C");
        assertThat(underTest.matches(testHand), is(true));
    }

    @Test
    public void shouldReturnTrueWhenHighAceStraightExists() {
        final PokerHand testHand = PokerHand.fromString("TD JC QD KH AC");
        assertThat(underTest.matches(testHand), is(true));
    }

    @Test
    public void shouldReturnTrueWhenLowAceStraightExists() {
        final PokerHand testHand = PokerHand.fromString("2C 3D 4C 5D AH");
        assertThat(underTest.matches(testHand), is(true));
    }

    @Test
    public void shouldReturnFalseWhenNoStraightExists() {
        final PokerHand testHand = PokerHand.fromString("2C 3D 4C 5D 7H");
        assertThat(underTest.matches(testHand), is(false));
    }
}
