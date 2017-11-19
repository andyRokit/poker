package poker.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import poker.ApplicationException;

import java.io.File;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PokerFileProcessorServiceTest {
    @InjectMocks
    private PokerFileProcessorService underTest;

    @Mock
    private PokerHandProcessorService pokerHandProcessorService;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void shouldProcessEveryLine() {
        underTest.process(getTestFilePath("poker-hands.txt"));
        verify(pokerHandProcessorService, times(4)).process(any());
    }

    @Test
    public void shouldHandleIoException() {
        expectedEx.expect(ApplicationException.class);
        expectedEx.expectMessage("Error reading file.");
        underTest.process("invalid");
    }

    private String getTestFilePath(final String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file.getAbsolutePath();
    }
}
