package poker.services;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.rule.OutputCapture;
import poker.model.PokerHand;
import poker.services.handmatchers.HandMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PokerHandProcessorServiceTest {
    @InjectMocks
    private PokerHandProcessorService underTest;

    @Spy
    private final List<HandMatcher> handMatchers = new ArrayList<>(2);

    @Mock
    private HandMatcher matcherOne;

    @Mock
    private HandMatcher matcherTwo;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Before
    public void setup() {
        handMatchers.add(matcherOne);
        handMatchers.add(matcherTwo);

        when(matcherOne.description()).thenReturn("One");
        when(matcherTwo.description()).thenReturn("Two");
    }

    @Test
    public void shouldReturnOneMatch() {
        final PokerHand testHand = mock(PokerHand.class);
        when(matcherOne.matches(testHand)).thenReturn(true);
        underTest.process(testHand);
        assertThat(outputCapture.toString(), is(testHand + " => One\n"));
    }

    @Test
    public void shouldReturnFirstMatch() {
        final PokerHand testHand = mock(PokerHand.class);
        when(matcherOne.matches(testHand)).thenReturn(true);
        when(matcherTwo.matches(testHand)).thenReturn(true);
        underTest.process(testHand);
        assertThat(outputCapture.toString(), is(testHand + " => One\n"));
    }

    @Test
    public void shouldReturnSecondMatch() {
        final PokerHand testHand = mock(PokerHand.class);
        when(matcherOne.matches(testHand)).thenReturn(false);
        when(matcherTwo.matches(testHand)).thenReturn(true);
        underTest.process(testHand);
        assertThat(outputCapture.toString(), is(testHand + " => Two\n"));
    }
}
