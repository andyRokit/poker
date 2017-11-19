package poker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poker.ApplicationException;
import poker.model.PokerHand;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class PokerFileProcessorService {
    @Autowired
    private PokerHandProcessorService pokerHandProcessorService;

    public void process(final String fileName) {
        Path path = Paths.get(fileName);
        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(this::processLine);
        } catch (IOException ex) {
            throw new ApplicationException("Error reading file.", ex);
        }
    }

    private void processLine(final String line) {
        PokerHand hand = PokerHand.fromString(line);
        pokerHandProcessorService.process(hand);
    }
}
