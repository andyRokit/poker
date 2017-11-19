package poker.services.handmatchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import poker.model.PokerHand;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StraightFlushMatchingServiceTest {
    @InjectMocks
    private StraightFlushMatchingService underTest;

    @Mock
    private StraightMatchingService straightMatchingService;

    @Mock
    private FlushMatchingService flushMatchingService;

    @Test
    public void shouldReturnCorrectDescription() {
        assertThat(underTest.description(), equalTo("Straight flush"));
    }

    @Test
    public void shouldReturnTrueWhenStraightAndFlush() {
        final PokerHand testHand = mock(PokerHand.class);
        when(straightMatchingService.matches(testHand)).thenReturn(true);
        when(flushMatchingService.matches(testHand)).thenReturn(true);
        assertThat(underTest.matches(testHand), is(true));
    }

    @Test
    public void shouldReturnTrueWhenStraightAndNotFlush() {
        final PokerHand testHand = mock(PokerHand.class);
        when(straightMatchingService.matches(testHand)).thenReturn(true);
        when(flushMatchingService.matches(testHand)).thenReturn(false);
        assertThat(underTest.matches(testHand), is(false));
    }

    @Test
    public void shouldReturnTrueWhenNotStraightAndFlush() {
        final PokerHand testHand = mock(PokerHand.class);
        when(straightMatchingService.matches(testHand)).thenReturn(false);
        when(flushMatchingService.matches(testHand)).thenReturn(true);
        assertThat(underTest.matches(testHand), is(false));
    }

    @Test
    public void shouldReturnTrueWhenNotStraightAndNotFlush() {
        final PokerHand testHand = mock(PokerHand.class);
        when(straightMatchingService.matches(testHand)).thenReturn(false);
        when(flushMatchingService.matches(testHand)).thenReturn(false);
        assertThat(underTest.matches(testHand), is(false));
    }
}
