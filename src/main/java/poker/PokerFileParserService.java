package poker;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class PokerFileParserService {
    public void parse(final String fileName) {
        Path path = Paths.get(fileName);
        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException ex) {
            throw new ApplicationException("Error reading file.", ex);
        }
    }
}
