package poker.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import poker.ApplicationException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RankTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void shouldCreateFromSymbol() {
        assertThat(Rank.fromSymbol('3'), is(Rank.THREE));
    }

    @Test
    public void shouldThrowExceptionWhenInvalidFormat() {
        expectedEx.expect(ApplicationException.class);
        expectedEx.expectMessage("X is not a valid rank");
        Rank.fromSymbol('X');
    }

    @Test
    public void shouldFormatToString() {
        assertThat(Rank.THREE.toSymbol(), is('3'));
    }
}
