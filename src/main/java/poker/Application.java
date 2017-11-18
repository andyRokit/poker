package poker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PokerFileParserService pokerFileParserService;

    @Override
    public void run(String... args) {
        if (args.length == 0) {
            System.out.println("Please specify input file.");
            System.exit(10);
        }

        final String filename = args[0];

        try {
            pokerFileParserService.parse(filename);
        } catch(final Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
