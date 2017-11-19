package poker.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import poker.ApplicationException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SuitTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void shouldCreateFromSymbol() {
        assertThat(Suit.fromSymbol('H'), is(Suit.HEARTS));
    }

    @Test
    public void shouldThrowExceptionWhenInvalidFormat() {
        expectedEx.expect(ApplicationException.class);
        expectedEx.expectMessage("X is not a valid suit");
        Suit.fromSymbol('X');
    }

    @Test
    public void shouldFormatToString() {
        assertThat(Suit.HEARTS.toSymbol(), is('H'));
    }
}
