package services.handmatchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import poker.model.PokerHand;
import poker.services.handmatchers.RoyalFlushMatchingService;
import poker.services.handmatchers.StraightFlushMatchingService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoyalFlushMatchingServiceTest {
    @InjectMocks
    private RoyalFlushMatchingService underTest;

    @Mock
    private StraightFlushMatchingService straightFlushMatchingService;

    @Test
    public void shouldReturnCorrectDescription() {
        assertThat(underTest.description(), equalTo("Royal flush"));
    }

    @Test
    public void shouldReturnTrueWhenRoyalFlush() {
        final PokerHand testHand = PokerHand.fromString("TC JC QC KC AC");
        when(straightFlushMatchingService.matches(testHand)).thenReturn(true);
        assertThat(underTest.matches(testHand), is(true));
    }

    @Test
    public void shouldReturnTrueWhenNotRoyalFlush() {
        final PokerHand testHand = PokerHand.fromString("9C TC JC QC KC");
        when(straightFlushMatchingService.matches(testHand)).thenReturn(true);
        assertThat(underTest.matches(testHand), is(false));
    }

    @Test
    public void shouldReturnTrueWhenNotStraightFlush() {
        final PokerHand testHand = PokerHand.fromString("9C JC QC KC AC");
        when(straightFlushMatchingService.matches(testHand)).thenReturn(false);
        assertThat(underTest.matches(testHand), is(false));
    }
}
