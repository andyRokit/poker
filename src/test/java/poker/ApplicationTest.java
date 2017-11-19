package poker;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootApplication
public class ApplicationTest {
    @Autowired
    private Application application;


    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void shouldGenerateResultFiles() throws Exception {
        application.run(getTestFilePath("poker-hands.txt"));
        assertThat(outputCapture.toString(), containsString("3H JS 3C 7C 5D => One pair\n" +
                "JH 2C JD 2H 4C => Two pair\n" +
                "9H 9D 3S 9S 9C => Four of a kind\n" +
                "9C 3H 9S 9H 3S => Full house\n"));
    }

    private String getTestFilePath(final String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file.getAbsolutePath();
    }
}
