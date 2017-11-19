package services.handmatchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import poker.model.PokerHand;
import poker.services.handmatchers.RankCountService;
import poker.services.handmatchers.FullHouseMatchingService;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FullHouseMatchingServiceTest {
    @InjectMocks
    private FullHouseMatchingService underTest;

    @Mock
    private RankCountService rankCountService;

    @Test
    public void shouldReturnCorrectDescription() {
        assertThat(underTest.description(), equalTo("Full house"));
    }

    @Test
    public void shouldReturnTrueWhenMatchExists() {
        final PokerHand testHand = mock(PokerHand.class);
        when(rankCountService.countRanks(testHand)).thenReturn(Arrays.asList(2, 3));
        assertThat(underTest.matches(testHand), is(true));
    }

    @Test
    public void shouldReturnFalseWhenNoMatchExists() {
        final PokerHand testHand = mock(PokerHand.class);
        when(rankCountService.countRanks(testHand)).thenReturn(Arrays.asList(1, 1, 1, 1, 1));
        assertThat(underTest.matches(testHand), is(false));
    }
}
