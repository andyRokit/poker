package poker.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import poker.model.PokerHand;
import poker.services.handmatchers.HandMatcher;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PokerHandProcessorServiceTest {
    @InjectMocks
    private PokerHandProcessorService underTest;

    @Spy
    private final List<HandMatcher> handMatchers = new ArrayList<>(2);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Spy
    private final PrintStream systemOut = new PrintStream(outContent);

    @Mock
    private HandMatcher matcherOne;

    @Mock
    private HandMatcher matcherTwo;

    @Before
    public void setup() {
        System.setOut(systemOut);

        handMatchers.add(matcherOne);
        handMatchers.add(matcherTwo);

        when(matcherOne.description()).thenReturn("One");
        when(matcherTwo.description()).thenReturn("Two");
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldReturnOneMatch() {
        final PokerHand testHand = mock(PokerHand.class);
        when(matcherOne.matches(testHand)).thenReturn(true);
        underTest.process(testHand);
        verify(systemOut).println(testHand + " => One");
    }

    @Test
    public void shouldReturnFirstMatch() {
        final PokerHand testHand = mock(PokerHand.class);
        when(matcherOne.matches(testHand)).thenReturn(true);
        when(matcherTwo.matches(testHand)).thenReturn(true);
        underTest.process(testHand);
        verify(systemOut).println(testHand + " => One");
    }

    @Test
    public void shouldReturnSecondMatch() {
        final PokerHand testHand = mock(PokerHand.class);
        when(matcherOne.matches(testHand)).thenReturn(false);
        when(matcherTwo.matches(testHand)).thenReturn(true);
        underTest.process(testHand);
        verify(systemOut).println(testHand + " => Two");
    }
}
